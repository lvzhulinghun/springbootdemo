package com.example.springbootdemo.testCode;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferTest {
        private static final String movie = "E:\\Beyond_Compare_4.1.9.21719.exe";   // 2.54G

        static byte[] bytes = new byte[512];
        public static void main(String[] args) {
            long startTime1 = System.currentTimeMillis();
            readByBuffer(movie);
            long endTime1 = System.currentTimeMillis();
            System.out.println(endTime1 - startTime1);

            long startTime2 = System.currentTimeMillis();
            readByInput(movie);
            long endTime2 = System.currentTimeMillis();
            System.out.println(endTime2 - startTime2);
        }


        private static void readByBuffer(String movie) {
            BufferedInputStream bufferedInputStream = null;
            try{
                bufferedInputStream = new BufferedInputStream(new FileInputStream(movie),157200);

                while (bufferedInputStream.read(bytes) != -1){
                }

            } catch (IOException e){
                e.printStackTrace();
            } finally {
                if (bufferedInputStream != null){
                    try{
                        bufferedInputStream.close();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }

        private static void readByInput(String movie) {
            InputStream inputStream = null;
            try{
                inputStream = new FileInputStream(movie);
                while (inputStream.read(bytes) != -1){
                }

            } catch (IOException e){
                e.printStackTrace();
            } finally {
                if (inputStream != null){
                    try{
                        inputStream.close();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
}
