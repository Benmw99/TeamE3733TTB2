package Entities;

public class FingerScannerJNI {
    static {
        System.loadLibrary("hello"); // Load native library hello.dll (Windows) or libhello.so (Unixes)
        //  at runtime
        // This library contains a native method called sayHello()
    }
    private native void sayHello();

    // Test Driver
    public static void main(String[] args) {
        new FingerScannerJNI().sayHello();  // Create an instance and invoke the native method
    }


}
