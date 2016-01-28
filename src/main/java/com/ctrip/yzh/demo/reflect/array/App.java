package com.ctrip.yzh.demo.reflect.array;

import java.lang.reflect.Array;

public class App {
	
    /**
     * @author yzh
     * @param args
     * @throws Exception
     */
    @SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
        /*
         *数组的反射
         *每个数组属于被映射为 Class 对象的一个类，
         *所有具有相同元素类型和维数的数组都共享该 Class 对象。
         */
        int [] intArray1=new int[]{1,2,3};
        int [] intArray2=new int[4];
        int [] []intArray3=new int[3][4];
        String[] stringArray=new String[]{"a","b","c"};
        System.out.println(intArray1.getClass()==intArray2.getClass());      // 输出为true
        //System.out.println(intArray1.getClass()==intArray3.getClass());    // 编译无法通过
        //System.out.println(intArray1.getClass()==stringArray.getClass());  // 编译无法通过
        
        System.out.println("intArray1 is "+intArray1.getClass().getName() );
        
        /*
         * 类 Object 是类层次结构的根类。
         * 每个类都使用 Object 作为超类。
         * 所有对象（包括数组）都实现这个类的方法。 
         */
        System.out.println("intArray1's parent is "+intArray1.getClass().getSuperclass().getName());
        System.out.println("intArray3's parent is "+intArray3.getClass().getSuperclass().getName());
        Object object1=intArray1;                // 基本类型的一维数组可以被当作Object类型使用
        //Object[] object5=intArray1;            // 编译出错.基本类型的一维数组不能当作Object[]类型使用，基本类型不是Object。
        Object object2=stringArray;              // 非基本类型的一维数组可以当作Object类型使用
        Object[] object4=stringArray;            // 非基本类型的一维数组可当作Object[]类型使用
        Object[] object3=intArray3;              // 数组可以为Object类型使用
        
        /*
         *Array类用于完成对数组的反射操作。
         *Array类提供了动态创建和访问Java数组的方法。 
         *Array允许在执行 get 或 set 操作期间进行扩展转换，
         *但如果发生收缩转换，则抛出 IllegalArgumentException。
         */
        
        Class<?> classType=Class.forName("java.lang.String");
        Object array=Array.newInstance(classType,10);
        Array.set(array, 5, "helloWorld!");
        String string=(String) Array.get(array, 5);
        System.out.println("The 5th is "+string);
        
        //多维数组反射,使用Array类静态方法创建三维、二维、一维数组，
        //并给数组的每个赋值并取出该值。
        int[] dims=new int[]{5,15,20};
        Object dimsarray3=Array.newInstance(int.class,dims);    // 此时为三维数组
        Object dimsarray2=Array.get(dimsarray3, 3);             // 此时为二维数组
        Class<?> cls=dimsarray2.getClass().getComponentType();  // 获得二维数组的Class类型
        dimsarray2=Array.get(dimsarray2, 5);    //此时为一维数组
        Array.set(dimsarray2, 10, 37);
        System.out.println("反射方法获取："+Array.get(dimsarray2, 10));
        int[][][] arrayCast=(int[][][]) dimsarray3;
        System.out.println("所设的值："+arrayCast[3][5][10]);         
    }
}