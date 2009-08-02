package com.wee.voyages;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * User: weejulius
 * Date: 2009-7-31
 * Time: 11:16:24
 */
public class Encoder {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    public void gbkToISO8859_1() {
        String[] charsets = {"ISO-8859-1", "UTF-8", "UTF-16BE", "UTF-16LE", "US-ASCII", "GBK"};
        byte[] bytes={(byte)0xC1,(byte)0XAA,(byte)0xCD,(byte)0XA8};
        for (String charset : charsets) {           
            log.debug(" after {} encoded:{}",  charset, Charset.forName(charset).decode(ByteBuffer.wrap(bytes)));
        }
    }
    @Test
    public void test(){
        String input = "中国";   

     // The list of charsets to encode with
     String[] charsetNames = { "US-ASCII", "ISO-8859-1", "UTF-8", "UTF-16BE", "UTF-16LE", "UTF-16",
     // "X-ROT13" // This requires META-INF/services
     };
     for (int i = 0; i < charsetNames.length; i++) {
       doEncode(Charset.forName(charsetNames[i]), input);
   }
    }
     private static void doEncode(Charset cs, String input) {   
     ByteBuffer bb = cs.encode(input);   
     System.out.println("Charset: " + cs.name());   
     System.out.println("  Input: " + input);   
     System.out.println("Encoded: ");   
   
     for (int i = 0; bb.hasRemaining(); i++) {   
       int b = bb.get();   
       int ival = ((int) b) & 0xff;   
       char c = (char) ival;   
       // print index number   
       System.out.print("  " + i + ": ");   
       // print the hex value of the byte   
       System.out.print(Integer.toHexString(ival));   
       System.out.println(" (" + c + ")");   
     }   
   }    
}
