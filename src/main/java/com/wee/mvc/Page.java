package com.wee.mvc;

/**
 * User: weejulius
 * Date: Aug 2, 2009
 * Time: 8:37:11 PM
 */
public class Page {
    private  int size;
    final private int total;
    private int maxIndex;
    final private int DEFAULT_START = 1;
    private int index;

    public Page(int size, int total) {
        this.size = size;
        this.total = total;
        maxIndex=maxIndex();
    }

    public Range index(int newIndex) {
        index=newIndex;
        index = index <= 0 ? DEFAULT_START : index;
        index = maxIndex>=size&&index > maxIndex ? maxIndex : index;
        return new Range((index - 1) * size, index * size);
    }

    public int maxIndex(){         
        return total<=0?1:(total-1)/size+1;
    }

    public int index(){
        return index;
    }

   

}
