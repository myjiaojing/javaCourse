package com.zcr.c001;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;


public class MyClassloader extends ClassLoader {

    public static void main(String[] args) throws Exception {
        Class helloClass = new MyClassloader().findClass("Hello");

        Method helloMethod = helloClass.getMethod("hello");
        helloMethod.invoke(helloClass.newInstance());

    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String mypath = "C:\\Hello.xlass";
        byte[] XlassBytes = getBytes(mypath);

        byte[] ClassBytes = new byte[XlassBytes.length];
        for (int i = 0;i < XlassBytes.length; i++){
            ClassBytes[i] = (byte) (255 - XlassBytes[i]);
        }


        return defineClass(name,ClassBytes,0,ClassBytes.length);
    }

    public byte[] getBytes(String path) {

        try (InputStream in = new FileInputStream(path)){

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024 * 4];
            int n = 0;
            while ((n = in.read(buffer)) != -1) {
                out.write(buffer, 0, n);
            }
            return out.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
}