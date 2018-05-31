package com.joy.java.util.common;

import com.joy.java.util.lang.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @Package: com.joy.java.util.common
 * @Class: ClassUtil
 * @Author: Joy
 * @date: 2018/5/7 17:21
 * @Description: class相关工具类,不使用反射.
 * @Param: param
 * @ReturnType:
 * @Exception
 **/
public class ClassUtil {

    /**
     * The package separator character: <code>'&#x2e;' == {@value}</code>.
     */
    public static final char PACKAGE_SEPARATOR_CHAR = '.';

    /**
     * The package separator String: <code>"&#x2e;"</code>.
     */
    public static final String PACKAGE_SEPARATOR = String.valueOf(PACKAGE_SEPARATOR_CHAR);

    /**
     * The inner class separator character: <code>'$' == {@value}</code>.
     */
    public static final char INNER_CLASS_SEPARATOR_CHAR = '$';

    /**
     * The inner class separator String: {@code "$"}.
     */
    public static final String INNER_CLASS_SEPARATOR = String.valueOf(INNER_CLASS_SEPARATOR_CHAR);
    /**
     * Maps a primitive class name to its corresponding abbreviation used in array class names.
     */
    private static final Map<String, String> abbreviationMap;

    /**
     * Maps an abbreviation used in array class names to corresponding primitive class name.
     */
    private static final Map<String, String> reverseAbbreviationMap;
    /**
     * Feed abbreviation maps
     */
    static {
        final Map<String, String> m = new HashMap<String, String>();
        m.put("int", "I");
        m.put("boolean", "Z");
        m.put("float", "F");
        m.put("long", "J");
        m.put("short", "S");
        m.put("byte", "B");
        m.put("double", "D");
        m.put("char", "C");
        m.put("void", "V");
        final Map<String, String> r = new HashMap<String, String>();
        for (Map.Entry<String, String> e : m.entrySet()) {
            r.put(e.getValue(), e.getKey());
        }
        abbreviationMap = Collections.unmodifiableMap(m);
        reverseAbbreviationMap = Collections.unmodifiableMap(r);
    }

    /**
     * 获取类的短类名
     * @param cls
     * @return String
     */
    public static String getShortClassName(final Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return getShortClassName(cls.getName());
    }

    /**
     * 获取类的短类名
     * @param className 全类名
     * @return String
     */
    public static String getShortClassName(String className) {
        if (StringUtil.isEmpty(className)) {
            return null;
        }

        final StringBuilder arrayPrefix = new StringBuilder();

        // Handle array encoding
        if (className.startsWith("[")) {
            while (className.charAt(0) == '[') {
                className = className.substring(1);
                arrayPrefix.append("[]");
            }
            // Strip Object type encoding
            if (className.charAt(0) == 'L' && className.charAt(className.length() - 1) == ';') {
                className = className.substring(1, className.length() - 1);
            }

            if (reverseAbbreviationMap.containsKey(className)) {
                className = reverseAbbreviationMap.get(className);
            }
        }

        final int lastDotIdx = className.lastIndexOf(PACKAGE_SEPARATOR_CHAR);
        final int innerIdx = className.indexOf(
                INNER_CLASS_SEPARATOR_CHAR, lastDotIdx == -1 ? 0 : lastDotIdx + 1);
        String out = className.substring(lastDotIdx + 1);
        if (innerIdx != -1) {
            out = out.replace(INNER_CLASS_SEPARATOR_CHAR, PACKAGE_SEPARATOR_CHAR);
        }
        return out + arrayPrefix;
    }

    /**
     * <p>通过 {@code Class}获取包名.</p>
     * @param cls
     * @return String
     */
    public static String getPackageName(final Class<?> cls) {
        if (cls == null) {
            return StringUtils.EMPTY;
        }
        return getPackageName(cls.getName());
    }

    /**
     * <p> 通过{@code String}获取包名.</p>
     * @param className
     * @return String
     */
    public static String getPackageName(String className) {
        if (StringUtils.isEmpty(className)) {
            return StringUtils.EMPTY;
        }

        // Strip array encoding
        while (className.charAt(0) == '[') {
            className = className.substring(1);
        }
        // Strip Object type encoding
        if (className.charAt(0) == 'L' && className.charAt(className.length() - 1) == ';') {
            className = className.substring(1);
        }

        final int i = className.lastIndexOf(PACKAGE_SEPARATOR_CHAR);
        if (i == -1) {
            return StringUtils.EMPTY;
        }
        return className.substring(0, i);
    }

    /**
     * 根据类信息获取全类名
     * @param classes
     * @return List<String>
     */
    public static List<String> convertClassesToClassNames(final List<Class<?>> classes) {
        if (classes == null) {
            return null;
        }
        final List<String> classNames = new ArrayList<String>(classes.size());
        for (final Class<?> cls : classes) {
            if (cls == null) {
                classNames.add(null);
            } else {
                classNames.add(cls.getName());
            }
        }
        return classNames;
    }

    /**
     * 根据全类名获取所有的类
     * @param classNames 全类名
     * @return List<Class<?>>
     */
    public static List<Class<?>> convertClassNamesToClasses(final List<String> classNames) {
        if (classNames == null) {
            return null;
        }
        final List<Class<?>> classes = new ArrayList<Class<?>>(classNames.size());
        for (final String className : classNames) {
            try {
                classes.add(Class.forName(className));
            } catch (final Exception ex) {
                classes.add(null);
            }
        }
        return classes;
    }

    /**
     * 或者这个类所有实现的接口
     * @param cls
     * @return List<Class<?>>
     */
    public static List<Class<?>> getAllInterfaces(final Class<?> cls) {
        if (cls == null) {
            return null;
        }

        final LinkedHashSet<Class<?>> interfacesFound = new LinkedHashSet<Class<?>>();
        getAllInterfaces(cls, interfacesFound);

        return new ArrayList<Class<?>>(interfacesFound);
    }

    /**
     * Get the interfaces for the specified class.
     *
     * @param cls  the class to look up, may be {@code null}
     * @param interfacesFound the {@code Set} of interfaces for the class
     */
    private static void getAllInterfaces(Class<?> cls, final HashSet<Class<?>> interfacesFound) {
        while (cls != null) {
            final Class<?>[] interfaces = cls.getInterfaces();

            for (final Class<?> i : interfaces) {
                if (interfacesFound.add(i)) {
                    getAllInterfaces(i, interfacesFound);
                }
            }

            cls = cls.getSuperclass();
        }
    }

    /**
     * 或者这个类所有的父类
     * @param cls
     * @return List<Class<?>>
     */
    public static List<Class<?>> getAllSuperclasses(final Class<?> cls) {
        if (cls == null) {
            return null;
        }
        final List<Class<?>> classes = new ArrayList<Class<?>>();
        Class<?> superclass = cls.getSuperclass();
        while (superclass != null) {
            classes.add(superclass);
            superclass = superclass.getSuperclass();
        }
        return classes;
    }
}

