package com.erichgamma.api.proxy;

import java.util.function.Function;

public class TypeProxy {

    public static Function<?, String> string = String::valueOf;

    public static Function<String, Integer> integer = Integer::valueOf;
    public static Function<String, Double> doubleof = Double::valueOf;
    public static Function<String, Float> floatof = Float::valueOf;

}
