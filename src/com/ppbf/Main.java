package com.ppbf;

import com.ppbf.helpers.Setup;
import java.io.FileNotFoundException;

public class Main {

    //  throws clause vs try-catch block
    //  throws clause    - used to indicate that particular exception is possibly thrown from
    //                     executing method at run-time
    //  try-catch block  - used to handle exception scenario
    public static void main(String[] args) throws FileNotFoundException {
        Setup.startSandbox();
    }
}
