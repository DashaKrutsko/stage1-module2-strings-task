package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;


public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     * 1. access modifier - optional, followed by space: ' '
     * 2. return type - followed by space: ' '
     * 3. method name
     * 4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     * accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     * private void log(String value)
     * Vector3 distort(int x, int y, int z, float magnitude)
     * public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */

    public MethodSignature parseFunction(String signatureString) throws UnsupportedOperationException {
        List<MethodSignature.Argument> argumentList = new ArrayList<>();
        String[] methodAndArguments = signatureString.split("\\(");
        String stringArguments = methodAndArguments[1].substring(0, methodAndArguments[1].length() - 1);
        if (stringArguments.length() > 0) {
            String[] arguments = stringArguments.split(", ");
            for (String arg : arguments) {
                String[] argString = arg.split(" ");
                MethodSignature.Argument argument = new MethodSignature.Argument(argString[0], argString[1]);
                argumentList.add(argument);
            }
        }
        String methodDescription = methodAndArguments[0];
        String[] descriptions = methodDescription.split(" ");
        int lenght = descriptions.length;
        String methodName = descriptions[lenght - 1];
        MethodSignature methodSignature = new MethodSignature(methodName, argumentList);

        if (lenght == 3) {
            methodSignature.setReturnType(descriptions[1]);
            methodSignature.setAccessModifier(descriptions[0]);
        } else {
            methodSignature.setReturnType(descriptions[0]);
        }
        return methodSignature;
    }
}
