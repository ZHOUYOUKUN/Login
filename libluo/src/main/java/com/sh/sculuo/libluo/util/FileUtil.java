package com.sh.sculuo.libluo.util;

import android.os.Environment;
import android.text.TextUtils;

import com.sh.sculuo.libluo.App;

import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luoxiaocheng on 2017/7/21.
 */

public final class FileUtil {
    public static File getCacheFile(String fileName) {
        return new File(App.context.getCacheDir(), fileName);
    }
    /**
     * 文件查询路径
     *
     * @param path
     * @return
     */
    public final static Map<String, File> getFiles(String path) {
        return getFiles(path, new String[0]);
    }

    public final static Map<String, File> getFiles(String path, String[] regulars) {
        Map<String, File> maps = new HashMap<>();
        if (!TextUtils.isEmpty(path)) {
            File rootFile = new File(path);
            if (rootFile.exists()) {
                FileFilter fileFilter = null;
                if (regulars != null) {
                    fileFilter = new RegularFileFilter(regulars);
                }
                getChildFiles(rootFile, maps, fileFilter);
            }
        }
        return maps;
    }

    public final static Map<String, File> getFiles(String path, FileFilter fileFilter) {
        Map<String, File> maps = new HashMap<>();
        if (!TextUtils.isEmpty(path)) {
            File rootFile = new File(path);
            if (rootFile.exists()) {
                getChildFiles(rootFile, maps, fileFilter);
            }
        }
        return maps;
    }

    private static final void getChildFiles(File chiledFile, Map<String, File> maps, FileFilter fileFilter) {
        boolean directory = chiledFile.isDirectory();
        if (directory) {
            File[] files;
            if (fileFilter == null)
                files = chiledFile.listFiles();
            else
                files = chiledFile.listFiles(fileFilter);
            for (File file : files) {
                getChildFiles(file, maps, fileFilter);
            }
        } else {
            maps.put(chiledFile.getPath(), chiledFile);
        }
    }

    private static String rootPath = null;

    /**
     * 返回应用文件保存的根目录
     *
     * @return
     */
    public static File getRootFile() {
        if (!TextUtils.isEmpty(rootPath))
            return new File(rootPath);
        boolean sdCardExist = Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED); // 判断sd卡是否存在
        String packageName = App.context.getPackageName();
        File root;
        if (sdCardExist) {
//			File dir = Environment.getExternalStorageDirectory ();
            root = new File("/sdcard/Android/data/"+packageName);
            if (root.exists()) {
                rootPath = root.getPath();
            } else {
                boolean mkdir = root.mkdir();
                if (mkdir)
                    rootPath = root.getPath();
                else {
                    root = new File("/data/data/" + packageName + "/cache");
                    rootPath = root.getPath();
                }
            }
        } else {
            root = new File("/data/data/" + packageName + "/cache");
            if (!root.exists()) {
                root.mkdirs();
            }
            rootPath = root.getPath();
        }
        return root;
    }

    public static File getNameByFile(String name) {

        File rootFile = getRootFile();
        if (TextUtils.isEmpty(name))
            return rootFile;
        return new File(rootFile, name);
    }

    private static class RegularFileFilter implements FileFilter {
        private String[] regulars;

        public RegularFileFilter(String[] regulars) {
            this.regulars = regulars;
        }

        @Override
        public boolean accept(File file) {
            if (regulars == null||regulars.length==0)
                return true;
            for (String item : regulars) {
                if (file.getName().toLowerCase().endsWith(item.toLowerCase())||file.isDirectory()) {

                    return true;
                }
            }
            return false;
        }
    }
}
