package com.avminin.array;

import java.util.Arrays;
import java.util.Collections;

public class CompressTheArrayIntoRanges {
    public String compressArray(int [] array) {
        if (array.length == 0) {
            return "";
        } else if (array.length == 1) {
            return String.valueOf(array[0]);
        }
        String result = "";
        Arrays.sort(array);
        int start = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] != array[i - 1] + 1) {
                if (array[i - 1] == start) {
                    result += start + ", ";
                } else {
                    result += "[" + start + "-" + array[i - 1] + "], ";
                }
                start = array[i];
            }
        }
        if (array[array.length - 1] != array[array.length - 2] + 1) {
            result += array[array.length - 1];
        } else {
            result += "[" + start + "-" + array[array.length - 1] + "]";
        }
        return result;
    }
}
