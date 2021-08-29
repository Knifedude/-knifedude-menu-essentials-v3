package com.knifedude.menuessentials.api.common.validation;


import com.google.common.base.Preconditions;

public class Assert {

    private Assert() {}

    public static void notNull(Object argumentValue, String argumentName) {
        Preconditions.checkNotNull(argumentValue, String.format("Argument '%s' was null, but is mandatory", argumentName));
    }

    public static void greaterThan(int argumentValue, String argumentName, int target) {
        Preconditions.checkArgument(argumentValue > target, String.format("Argument '%s' must be greater than '%d', but was '%d'", argumentName, target, argumentValue));
    }

    public static void greaterThanZero(int argumentValue, String argumentName) {
        greaterThan(argumentValue, argumentName, 0);
    }



}
