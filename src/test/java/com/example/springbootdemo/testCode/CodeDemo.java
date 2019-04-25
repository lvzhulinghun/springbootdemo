package com.example.springbootdemo.testCode;

import com.alibaba.fastjson.JSON;
import com.example.springbootdemo.ThreadTest.ConcurrentHashMapThread;
import com.example.springbootdemo.ThreadTest.ConcurrentSkipListMapThread;
import com.example.springbootdemo.ThreadTest.CopyOnWriteArrayListThread;
import com.example.springbootdemo.bean.Student;
import org.junit.Test;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CodeDemo {

    @Test
    public void test(){

       /* Object obj = new Object();
        System.out.println("getClass:"+obj.getClass());
        System.out.println("toString:"+obj.toString());
        System.out.println("hashcode:"+obj.hashCode());

//        Student student = new Student();
//        student.setName("崔春驰");
//        System.out.println("student:"+student.hashCode());
//        Student student1 = new Student();
//        student1.setName("崔春驰");
//        System.out.println("student1:"+student1.hashCode());
//        Student student2 = new Student();
//        student2.setName("崔春驰");
//        System.out.println("student2:"+student2.hashCode());
//        System.out.println(student.equals(student1));

        String str = "崔春驰1";
        String str1 = new String("崔春驰");
        System.out.println("str hashcode:"+str.hashCode());
        System.out.println("str1 hashcode:"+str1.hashCode());
        System.out.println(str.equals(str1));
        System.out.println("======================Appendable接口=======================");
        StringBuffer sb = new StringBuffer();
        CharSequence charSequence = "sss";
        String ss = null;
        sb.append(ss,0,1);
        Formatter formatter = new Formatter(sb,Locale.CANADA);
        System.out.println("formatter:"+formatter);

        System.out.println("===================AutoCloseable=======");
        try(SubAutoClose subAutoClose = new SubAutoClose()){
            subAutoClose.readResource();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("===============Boolean=================");
        System.out.println(Boolean.hashCode(false));
        System.out.println(Boolean.logicalAnd(true,false));
        System.out.println("===============byte===============");
        System.out.println(Byte.parseByte("112"));
        System.out.println(Byte.valueOf("12"));
        Byte b = new Byte("123");
        System.out.println(b.intValue());
        Byte b2 = new Byte("121");
        int i = b.compareTo(b2);
        System.out.println("compareTo:"+i);
        System.out.println(Byte.toUnsignedInt(b));
        System.out.println("===============character===================");
        Character character = new Character('崔');
        Character character1 = Character.valueOf('a');
        System.out.println(character.charValue());
        System.out.println(Character.codePointAt("1Aa",2));
        System.out.println(Character.codePointAt(new char[]{'/'},0));
        System.out.println(Character.codePointBefore("Aa",2));
        System.out.println(Character.isLowerCase('a'));
        System.out.println((int)'a');
        System.out.println(Character.isDigit('1'));
        System.out.println(Character.isLetter('1'));
        System.out.println(Student.class.getMethods()[0].getName());
        System.out.println("======================ClassLoader========================");
        ClassLoader classLoader = Student.class.getClassLoader();
        System.out.println("classLoader:"+classLoader);
        System.out.println("parent:"+classLoader.getParent());
        System.out.println("parent:"+classLoader.getParent().getParent());
        try {
            Class<?> student = classLoader.loadClass("com.example.springbootdemo.bean.Student");
            Method[] methods = student.getMethods();
            System.out.println("student:"+student + "\n" + methods[0].getName());

            System.out.println("resourse:"+Student.class.getResource("/"));
            System.out.println("resourse:"+Student.class.getClassLoader().getResource("1.properties"));
            System.out.println("getResourceAsStream："+Student.class.getClassLoader().getResourceAsStream("1.properties"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("=========================Compiler============================");
        String jit = System.getProperty("java.compiler");
        Properties properties = System.getProperties();
        System.out.println("jit:"+jit);
        System.out.println("properties:"+properties);

        System.out.println("=========================iterable============================");
        StudentIterable studentIterable = new StudentIterable();
        studentIterable.add("崔春驰");;
        studentIterable.add("你好");
        System.out.println(studentIterable.iterator().next().toString());
//        for (Object str11 : studentIterable){
//            System.out.println(str11.toString());
//        }
        studentIterable.forEach((s)-> System.out.println(s.toString()));

        System.out.println("=================readable====================");
        Scanner scanner = new Scanner(new SubReadable(2));
        while (scanner.hasNext()){
            System.out.println("进入while里面");
            System.out.println(scanner.next());
        }

        System.out.println("================Runtime======================");
        System.out.println("jvm可执行的处理器数"+Runtime.getRuntime().availableProcessors());
        System.out.println("空闲内存"+Runtime.getRuntime().freeMemory());
        System.out.println("最大内存"+Runtime.getRuntime().maxMemory());
        System.out.println("总的内存"+Runtime.getRuntime().totalMemory());

        Runtime runtime = Runtime.getRuntime();
        Process process = null;//打开记事本程序，并返回一个进程
        try {
            process = runtime.exec("C:\\Windows\\notepad.exe");
            Thread.sleep(1000); //让当前程序停止3秒。
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("===============String=====================");
        String str12 = new String("崔春驰");
        char ch[] = {'崔','从','出'};
        String ss1 = new String(ch);
        System.out.println(ss1);
        System.out.println("charAt:"+str12.charAt(2));
        System.out.println("codePointAt:"+str12.codePointAt(0));
        System.out.println("contentEquals:"+str12.contentEquals("崔春驰"));
        System.out.println("startWith:"+str12.startsWith("崔春驰",1));
        System.out.println("join:"+String.join("-","java","c++","php"));
        System.out.println("concat:"+str12.concat("123"));

        String s3 = new String("1") + new String("1");
        s3.intern();//将堆内存的字符串对象复制到常量池中，先从常量池中取，
        String s4 = "11";
        System.out.println(s3 == s4);

//        List<String> list = new ArrayList<String>();
//        int i1=110;
//        while(true){
//            list.add(String.valueOf(i1++).intern());
//        }
        StringBuffer sbb = new StringBuffer("崔春驰");
        System.out.println("StringBuffer:"+sbb.length());
        System.out.println("capacity:"+sbb.capacity());
        sbb.ensureCapacity(19);
        System.out.println("capacity2:"+sbb.capacity());
        sbb.setLength(10);
        System.out.println("StringBuffer222:"+sbb.length());
        System.out.println("append:"+sbb.append("是"));

        StringBuffer spp = new StringBuffer();
        spp.append("崔春驰111111111111");
        System.out.println("spp--capacity:"+spp.capacity() + " ; count:"+spp.length());
//        String ssss = null;
        spp.insert(spp.length(),"我");
        System.out.println("spp--capacity:"+spp.capacity() + " ; count:"+spp.length());
        System.out.println("reverse:"+spp.reverse());
        StringBuffer spp1 = spp.append("fff");
        System.out.println("spp:"+spp.toString() + " ; spp1:"+spp1.toString());
        spp1.delete(0,spp1.length());
        System.out.println("spp:"+spp.toString() + " ; spp1:"+spp1.toString() + " : capacity:"+spp1.capacity() + " ;count:"+spp1.length());
        System.out.println("==========================StringBuilder===================");*/
       /* System.out.println("==========================fileInputStream======================");
        String fileName = "C:\\Users\\MTW\\Desktop\\55.txt";
        String fileName2 = "C:\\Users\\MTW\\Desktop\\66.txt";
        try {
            FileInputStream fis = new FileInputStream(fileName);
            int pos = 0;
            //一个汉字3个字节
            byte[] b = new byte[2];
            *//*while((pos = fis.read())!= -1){
                System.out.println("fileInputStream ---->read():"+pos + ":内容："+(char)pos);
            }*//*
            System.out.println("available: "+fis.available());
            for (int i = 0; i < 4; i++) {
                System.out.print("第"+(i+1)+"次读取返回的结果:"+fis.read(b) );
                System.out.println(",读取后数组b的内容为:"+Arrays.toString(b));
            }
            String chunk = new String(b, 0, b.length);
            System.out.println(chunk);
            fis.close();
            int bytesRead = 0;
            System.out.println("======================BufferedInputStream=================");
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName2),3);
            *//*int read = bis.read();
            System.out.println("BUfferedInputStream---->read():"+read);
            bis.mark(1);
            int read1 = bis.read();
            System.out.println("BUfferedInputStream--2-->read():"+read1);
            int read2 = bis.read();
            System.out.println("BUfferedInputStream--3-->read():"+read2);
            bis.reset();
//            bis.mark(2);
            int read3 = bis.read();
            System.out.println("BUfferedInputStream--4-->read():"+read3);
            int read4 = bis.read();
            System.out.println("BUfferedInputStream--5-->read():"+read4);
            int read5 = bis.read();
            System.out.println("BUfferedInputStream--6-->read():"+read5);
            bis.reset();
            int read6 = bis.read();
            System.out.println("BUfferedInputStream--7-->read():"+read6);*//*

            byte[] buffer = new byte[4];
           *//* for (int i = 0; i < 3; i++) {
                System.out.print("第"+(i+1)+"次读取返回的结果:"+bis.read(buffer));
                System.out.println(",读取后数组b的内容为:"+Arrays.toString(buffer));
            }*//*
            //从文件中按字节读取内容，到文件尾部时read方法将返回-1
            while ((bytesRead = bis.read(buffer)) != -1) {
                //将读取的字节转为字符串对象
                String chunk1 = new String(buffer, 0, bytesRead,"UTF-8");
//                System.out.print(chunk1);
                bos.write(buffer,0,bytesRead);
            }
//            int a = 1/0;
            bos.close();
            bis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("==========================ByteArrayInputStream=====================");
        ByteArrayInputStream bais = new ByteArrayInputStream("ABCDEFG".getBytes());
        ByteArrayOutputStream baos  = new ByteArrayOutputStream(3); //默认32个字节
//        int read111 = bais.read();
//        baos.write(read111);
//        System.out.println(baos.toString());
        *//*for(int oo = 0; oo<7 ; oo++){
            if(bais.available() > 0){
                int read = bais.read();
                baos.write(read);
            }
        }*//*
        byte a[] = new byte[2];
        int pp = 0;
        while((pp = bais.read(a,0,a.length)) != -1){
            System.out.println("字节数组流"+new String(a,0,pp));
            baos.write(a,0,pp);
        }
        System.out.println("  :  "+baos.toString());
        System.out.println("===============================DataInputStream================");
        try {
            DataInputStream dis  = new DataInputStream(new ByteArrayInputStream("ABCDEFG".getBytes()));
            DataOutputStream dos = new DataOutputStream(new ByteArrayOutputStream());

            byte b[]= new byte[12];
//            dis.read(b);
//            dis.readFully(b);
            String s = dis.readLine();
            System.out.println("DataInputStream:======>"+new String(b) + " ;readLine:"+s);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("====================================Reader============================");
        try {
            InputStreamReader isr  = new InputStreamReader(new FileInputStream(fileName),"UTF-8");
            char bb[] = new char[10];
            isr.read(bb,0,bb.length);
            System.out.println("InputStreamReader========>:"+new String(bb));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader bd = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)),4);//默认8192个字符
           *//* int read12 = bd.read();
            int read333 = bd.read();
            bd.read();
            bd.read();
            bd.read();
            bd.read();
            System.out.println("bufferedRead========>"+read12);*//*
            *//*char gg[] = new char[3];
            int uu =0;
            StringBuffer sb = new StringBuffer();
            while((uu =  bd.read(gg,0,gg.length)) !=-1){
                String s1 = new java.lang.String(gg,0,uu);
                System.out.println("顶顶顶顶顶顶BufferedReader==============>"+ s1);
               sb.append(s1);
            }*//*
            String s = null;
            //按行读取
            *//*while((s = bd.readLine()) != null){
                System.out.println("bufferedReadffff========>"+s);
            }*//*
            System.out.println(JSON.toJSON(bd.lines().toArray()));
            FileReader fr = new FileReader(fileName);
//            int readw = fr.read();
            char pp1[] = new char[15];
            fr.read(pp1,0,pp1.length);
            System.out.println("FileReader===============>"+new String(pp1));

            System.out.println("===================LineNumberReader==========================");
            LineNumberReader lnr = new LineNumberReader(new InputStreamReader(new FileInputStream(fileName)));
            int ol = 0;
            char gh[] = new char[3];
            StringBuffer sbb = new StringBuffer();
            lnr.setLineNumber(1);
           *//* while((ol = lnr.read(gh,0,gh.length))!= -1){
                String s1 = new String(gh, 0, ol);
                System.out.println("LineNumberReader======第"+lnr.getLineNumber()+"行========>"+ s1+"" );
//                sbb.append(s1);
            }*//*
           *//* String s1 = null;
            lnr.setLineNumber(0);
//            lnr.skip(2);
            while((s1 = lnr.readLine())!=null){
                System.out.println("readLine====第"+lnr.getLineNumber()+"=行====dddd=>"+s1);
            }*//*

           *//* System.out.println("======================CharArrayReader=========================");
            char ad [] = new char[20];
            CharArrayReader car = new CharArrayReader(ad);
            StringReader sr = new StringReader("大撒山东省");
            int read22 = sr.read();
            System.out.println("StringReader========>"+(char)read22);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        System.out.println("======================RandomAccessFile=======================");
        String fileName = "C:\\Users\\MTW\\Desktop\\55.txt";
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileName,"rw");
           /* byte a[] = new byte[1024];
//            randomAccessFile.read(a,0,a.length);
////            randomAccessFile.readFully(a);
//            System.out.println(new String(a,0,a.length));
            randomAccessFile.writeInt(123);
            randomAccessFile.writeUTF("崔春驰");
            randomAccessFile.write(222);
            randomAccessFile.writeDouble(22.4);

            randomAccessFile.seek(0);
            System.out.println("获取当前的偏移量filePointer;"+ randomAccessFile.getFilePointer());
            System.out.println("读取内容：==》"+randomAccessFile.readInt() + " ;name:" +randomAccessFile.readUTF() + " : " +randomAccessFile.read()
            +" : "+"获取当前的偏移量filePointer;"+ randomAccessFile.getFilePointer()+" : "+randomAccessFile.readDouble());
            System.out.println("获取当前的偏移量filePointer;"+ randomAccessFile.getFilePointer());
            randomAccessFile.seek(randomAccessFile.length());
            System.out.println("追加内容");
            randomAccessFile.writeUTF("\r\n追加的内容崔春驰");*/

            System.out.println("===================合并流SequenceInputStream================");
           /* Vector<InputStream> vector  = new Vector<InputStream>();
            vector.add(new BufferedInputStream(new FileInputStream(fileName)));
            String fileName22 = "C:\\Users\\MTW\\Desktop\\66.txt";
            vector.add(new FileInputStream(fileName22));
            String fileName223 = "C:\\Users\\MTW\\Desktop\\662.txt";
            vector.add(new FileInputStream(fileName223));
            Enumeration<InputStream> elements = vector.elements();
            SequenceInputStream sis = new SequenceInputStream(elements);
            String fileNameos = "C:\\Users\\MTW\\Desktop\\77.txt";
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileNameos));
            byte pp[] = new byte[1024];
            int ii = 0;
            while((ii = sis.read(pp))!=-1){
                bos.write(pp,0,ii);
                bos.flush();
            }

            bos.close();
            sis.close();*/

            System.out.println("==================集合框架源码分析Collection==========================");
           /* LinkedList<String> ll = new LinkedList<String>();
            ll.add("A");
            ll.add("B");
            ll.add("3");
            ll.addAll(1,Arrays.asList("C","D"));
            ll.add("AA");
            ll.add("BB");
            System.out.println(ll.set(2,"R") +"\n" + ll);
            Spliterator<String> spliterator01 = ll.spliterator();
            Spliterator<String> spliterator02 = spliterator01.trySplit();
            Spliterator<String> spliterator03 = spliterator02.trySplit();
            System.out.println("spliterator====>"+spliterator02.estimateSize());
            spliterator02.forEachRemaining(new Consumer<String>() {
                @Override
                public void accept(String s) {
                    System.out.println(Thread.currentThread().getName()+"spliterator02 === "+s);
                }
            });
            spliterator03.forEachRemaining((o)->{
                System.out.println(Thread.currentThread().getName()+"spliterator03 === "+o);
            });
            System.out.println("================linked的遍历，正向遍历，逆向遍历=============");
            Iterator<String> iterator = ll.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }
            System.out.println("逆向============");
            ListIterator<String> stringListIterator = ll.listIterator(7);
            while(stringListIterator.hasPrevious()){
                System.out.println(stringListIterator.previous());
            }*/
           Vector<String> vec = new Vector<>(3,1);
           vec.add("A");vec.add("B");vec.add("C");
           System.out.println("容量："+vec.capacity()+"  个数 count"+vec.size());
           vec.trimToSize();
            System.out.println("容量："+vec.capacity()+"  个数 count"+vec.size());
            vec.add("D");
            Enumeration<String> elements = vec.elements();

            System.out.println("=========arraylist===========");
            List<String> array = new ArrayList<>(3);//每次扩容1.5倍  可以存放null
            array.add("A");
            array.add("B");array.add("C");
            array.add("d");

            System.out.println("=============hashMap==============");

            Student s1 = new Student("崔春驰1",1);
            Student s2 = new Student("崔春驰2",2);
            Student s3 = new Student("崔春驰3",3);
            Student s4 = new Student("崔春驰4",4);
            Student s5 = new Student("崔春驰5",5);
            Student s6 = new Student("崔春驰6",6);
            Student s7 = new Student("崔春驰7",7);
            Student s8 = new Student("崔春驰8",8);
            Student s9 = new Student("崔春驰9",9);
            Student s10 = new Student("崔春驰10",10);
            Student s11 = new Student("崔春驰11",11);
           /* HashMap<Student,String> map  = new HashMap<>(64);
            map.put(s1,"1");
            map.put(s2,"2");
            map.put(s3,"3");
            map.put(s4,"4");
            map.put(s5,"5");
            map.put(s6,"6");
            map.put(s7,"7");
            map.put(s8,"8");
            map.put(s9,"9");//才扩容，到64，单链表转为红黑树最低的容量为64
            map.put(s10,"10");
            map.put(s11,"11");
*/
            LinkedHashMap<Student,String> lhm = new LinkedHashMap<>(2,0.75f,true);
            lhm.put(s1,"1");
            lhm.put(s2,"2");
            lhm.put(s3,"3");
            lhm.put(s4,"4");
            lhm.put(s2,"8");
//            lhm.put(s1,"1");
            lhm.get(s1);
//            lhm.replace(s1,"8");
//            lhm.get(s3);
            Set<Map.Entry<Student, String>> entries = lhm.entrySet();
            for(Map.Entry<Student,String> entry :entries){
                System.out.println(entry.getValue());
            }

            System.out.println("===============TreeMap====================");
           /* Map<Student,String> treemap = new TreeMap<>();
            treemap.put(s5,"5");
            treemap.put(s2,"2");
            treemap.put(s4,"4");
            treemap.put(s1,"1");
            treemap.put(s3,null);*/
            /*treemap.get(s4);
            Map.Entry<Student, String> entry1 = ((TreeMap<Student, String>) treemap).firstEntry();
            System.out.println(entry1.getKey() + "---- "+entry1.getValue());
            System.out.println("key----------->"+((TreeMap<Student, String>) treemap).firstKey());
            Set<Map.Entry<Student, String>> entries = treemap.entrySet();
            for(Map.Entry<Student,String> entry :entries){
                System.out.println(entry.getValue());
            }*/

           /* System.out.println("===========WeakHashMap（弱引用）==不用内存溢出问题，GC的时候自动清除不再使用的key到queue队列中，" +
                    "当下一次需要操作的时候，同步queue与table，就是删除table数组中的弱键============");
            WeakHashMap<String,Student> whm = new WeakHashMap<String,Student>(16,0.75f);
            String ss1  = new String("1");
            String ss2 = new String("2");
            String ss3 = new String("3");
            whm.put(ss1,s1);
            whm.put(ss2,s2);
            whm.put(ss3,s3);
            System.out.printf("whm:%s",whm+"\n");
            boolean b = whm.containsKey("3");
            boolean b1 = whm.containsValue(s2);
            System.out.println("b="+b+";b1="+b1);
            whm.remove(ss3);
            System.out.printf("whm:%s\n",whm);

            ss1=null;
            System.gc();
            Iterator<String> iterator = whm.keySet().iterator();
            while(iterator.hasNext()){
                String next = iterator.next();
                System.out.println("next---->"+next);

            }
           *//* Iterator<Map.Entry<String, Student>> iterator = whm.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry en = (Map.Entry)iterator.next();
                System.out.printf("next : %s - %s\n",en.getKey(),en.getValue());
            }*//*
            // 打印WeakHashMap的实际大小
            System.out.printf(" after gc WeakHashMap size:%s\n", whm.size() + ":"+whm.get(ss1));*/
           /* System.out.println("=================HashSet=====================");
            HashSet set = new HashSet();
            set.add("1");
            set.add("4");
            set.add("1");
            set.add("33");
            set.add("2");
            System.out.println("add 重复的："+set.add("1"));
            set.remove("1");
            Iterator iterator = set.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }
            System.out.println("=================LinkedHashSet=======================");
            LinkedHashSet lhs = new LinkedHashSet();
            lhs.add("1");
            lhs.add("4");
            lhs.add("1");
            lhs.add("33");
            lhs.add("2");
            Iterator iterator1 = lhs.iterator();
            while(iterator1.hasNext()){
                System.out.println(iterator1.next());
            }
            System.out.println("================TreeSet======================");
            TreeSet treeSet = new TreeSet();

            Collection list = new ArrayList();
            list.add("creek");
            list.add("misty");
            list.add("forest");

            Iterator iter = list.iterator();

            while (iter.hasNext()) {
                Object obj = iter.next();
                if ("creek".equals(obj))
                    list.remove(obj);
            }*/

            /*System.out.println("==============CopyOnWriteArrayList=CopyOnWriteArraySet=================");
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            CopyOnWriteArrayListThread cowalt = new CopyOnWriteArrayListThread(copyOnWriteArrayList,copyOnWriteArraySet);
            Thread tt = new Thread(cowalt);
            tt.start();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            copyOnWriteArrayList.add(1);
            copyOnWriteArraySet.add(1);
            ListIterator listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
            while(listIterator.hasPrevious()){
                System.out.print(listIterator.previous() + " ");
            }
            System.out.println();
            System.out.println("============CopyOnWriteArraySet==========");
            Iterator iterator1 = copyOnWriteArraySet.iterator();
            while(iterator1.hasNext()){
                System.out.print(iterator1.next() + " ");
            }

            System.out.println();
            System.out.println("======================");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Iterator iterator = copyOnWriteArrayList.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }

            System.out.println();
            System.out.println("============CopyOnWriteArraySet==========");
            Iterator iterator2 = copyOnWriteArraySet.iterator();
            while(iterator2.hasNext()){
                System.out.print(iterator2.next() + " ");
            }*/

            System.out.println("========测试性能==============");
            ConcurrentSkipListMap<String,Integer> concurrentSkipListMap = new ConcurrentSkipListMap<>();
           /* ConcurrentHashMap<String,Integer> chm = new ConcurrentHashMap<>();
            int total =2000001;
            Thread t = new Thread(new ConcurrentHashMapThread(chm,total));
            t.start();
            Thread t1 = new Thread(new ConcurrentSkipListMapThread(concurrentSkipListMap,total));
//            t1.start();
            try {
                Thread.sleep(4000);
                String key = "key2000000";
                long a = System.currentTimeMillis();
                Integer integer = chm.get(key);
                long b = System.currentTimeMillis();
                System.out.println("ConcurrentHashMap 查找时长："+(b-a) + " ; value:"+ integer);
                long a1 = System.currentTimeMillis();
                Integer integer1 = concurrentSkipListMap.get(key);
                long b1 = System.currentTimeMillis();
                System.out.println("ConcurrentSkipListMap 查找时长："+(b1-a1)+ " ; value:"+ integer);

                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            //有序的，
           /* concurrentSkipListMap.put("b",3);
            concurrentSkipListMap.put("b",1);
            concurrentSkipListMap.put("c",2);
            Set<Map.Entry<String, Integer>> entries = concurrentSkipListMap.entrySet();
            Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }*/
            System.out.println("==============ConcurrentLinkedQueueb支持多线程的非阻塞队列==================");
           /* ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
            queue.offer(10);
            queue.offer(20);
            queue.offer(30);
            queue.offer(40);
            queue.add(50);
            Object poll = queue.poll();
            Object poll1 = queue.poll();
            Object poll2 = queue.poll();
            System.out.println("poll--->"+poll +" ;"+ poll1  + ";"+ poll2);*/
            System.out.println("==============PriorityQueue无界优先级堆队列、线程不安全(默认二叉树中的小根堆排序)========================");
           /* PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(10);
            priorityQueue.add(6);
            priorityQueue.offer(3);
            priorityQueue.offer(5);
            priorityQueue.offer(1);
            priorityQueue.offer(4);
            priorityQueue.offer(2);
            Integer poll = priorityQueue.poll();
            Integer poll1 = priorityQueue.poll();
            Integer poll2 = priorityQueue.poll();
            priorityQueue.poll();
            priorityQueue.poll();
            System.out.println(poll + " ; " + poll1 + " ; "+poll2);
            List<Integer>  a = new ArrayList();
            a.add(3);
            a.add(5);
            a.add(2);
            a.add(4);
            a.add(1);
            PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>(a);
            System.out.println( priorityQueue1);*/
            System.out.println("==========SynchronousQueue阻塞队列，每添加都必须有其他线程来执行移除操作==============");
           /* SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue();
            synchronousQueue.put(1);
            synchronousQueue.poll();*/
            System.out.println("==========ArrayBlockingQueue有界阻塞队列，分为公平以及非公平==============");
            /*ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(2,false);
            //add 添加到满了，报错   offer 会返回false   put 会阻塞
            arrayBlockingQueue.offer(1);
            arrayBlockingQueue.offer(2);
            boolean add = arrayBlockingQueue.offer(3);
//            arrayBlockingQueue.put(11);
            //peek 只返回头，不删除不阻塞   take 阻塞   poll:返回并删除头队列，不阻塞
            arrayBlockingQueue.peek();
            arrayBlockingQueue.take();
            Integer poll = arrayBlockingQueue.poll();
            System.out.println(poll);*/
            System.out.println("============LinkedBlockingQueue有界阻塞队列基于链表===============");
           /* LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>(3);
            AtomicInteger atomicInteger = new AtomicInteger(10);
            //put 方法不得插入null
           *//* linkedBlockingQueue.offer(1);
            linkedBlockingQueue.offer(2);
            linkedBlockingQueue.offer(3);
            linkedBlockingQueue.put(4);
            linkedBlockingQueue.take();*//*
            Thread tt = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                        while(true){
//                            Thread.sleep(1000);
                            int andIncrement = atomicInteger.getAndIncrement();
                            linkedBlockingQueue.put(andIncrement);
                            System.out.println("生产 线程一  i->"+andIncrement);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"线程一");
            Thread tt2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                        while(true){
                            Thread.sleep(1000);
                            int andIncrement = atomicInteger.getAndIncrement();
                            linkedBlockingQueue.put(andIncrement);
                            System.out.println("生产 线程二  i->"+andIncrement);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            Thread tt3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                        while(true){
                            Thread.sleep(8000);
                            Integer take = linkedBlockingQueue.take();
                            System.out.println(Thread.currentThread().getName() + "; 消费 i->"+take);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            tt.start();
//            tt2.start();
//            tt3.start();
//            tt.join();
//            tt2.join();

            Thread.sleep(30000);
            System.out.println(Thread.currentThread().getName()+"errrrr");
            linkedBlockingQueue.put(33);*/
            System.out.println("==========PriorityBlockingQueue==============");
           /* PriorityBlockingQueue<Integer> priorityBlockingQueue  = new PriorityBlockingQueue<>(3);
            priorityBlockingQueue.add(1);
            priorityBlockingQueue.take();
            priorityBlockingQueue.take();*/
            System.out.println("=================LinkedBlockingDeque=================");
            LinkedBlockingDeque<Integer> linkedBlockingDeque = new LinkedBlockingDeque<>();
            System.out.println("=================DelayQueue=================");
            DelayQueue delayQueue = new DelayQueue();
            System.out.println("=================LinkedTransferQueue=================");
           /* LinkedTransferQueue linkedTransferQueue = new LinkedTransferQueue();
           *//* linkedTransferQueue.transfer(1);*//*

            AtomicInteger atomicInteger  = new AtomicInteger(10);
           Thread tt =  new Thread(new Runnable() {
                @Override
                public void run() {
                    int andIncrement2 = atomicInteger.getAndSet(11);
                    System.out.println(Thread.currentThread().getName() + andIncrement2);
                }
            },"线程一");

            Thread tt2 =  new Thread(new Runnable() {
                @Override
                public void run() {
                    int andIncrement3 = atomicInteger.getAndIncrement();
                    System.out.println(Thread.currentThread().getName() + andIncrement3);
                }
            },"线程二");

            tt.start();
            tt2.start();
            tt.join();
            tt2.join();*/

            /*final  Lock lock = new ReentrantLock(false);
            Condition condition = lock.newCondition();

            Thread tt =  new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName());
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    lock.unlock();
                }
            },"线程一");

            Thread tt2 =  new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName());

                    lock.unlock();
                }
            },"线程二");
            Thread tt3 =  new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName());
                }
            },"线程三");



            tt.start();
            tt2.start();
            tt3.start();
            lock.unlock();
            tt3.join();
            tt.join();
            tt2.join();*/

            String ss = "adsasda";
            ss.getBytes();
            ss.getBytes("ISO-8859-1");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
