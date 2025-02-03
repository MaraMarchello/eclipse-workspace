public class NoGenericMethods {
    private Object arg1;
    private Object arg2;
    private Object arg3;

    public NoGenericMethods(Object a1, Object a2, Object a3) {
        if (!areAllSameType(a1, a2, a3)) {
            throw new IllegalArgumentException("All arguments must be of the same type");
        }
        this.arg1 = a1;
        this.arg2 = a2;
        this.arg3 = a3;
    }

    private boolean areAllSameType(Object... objects) {
        if (objects == null || objects.length == 0) return true;
        Class<?> firstType = objects[0].getClass();
        for (Object obj : objects) {
            if (!obj.getClass().equals(firstType)) {
                return false;
            }
        }
        return true;
    }

    public void setArg1(Object arg) {
        validateType(arg);
        this.arg1 = arg;
    }

    public void setArg2(Object arg) {
        validateType(arg);
        this.arg2 = arg;
    }

    public void setArg3(Object arg) {
        validateType(arg);
        this.arg3 = arg;
    }

    private void validateType(Object newArg) {
        if (!areAllSameType(newArg, arg1, arg2, arg3)) {
            throw new IllegalArgumentException("New argument must be of the same type as existing arguments");
        }
    }

    public Object getArg1() {
        return arg1;
    }

    public Object getArg2() {
        return arg2;
    }

    public Object getArg3() {
        return arg3;
    }

    @Override
    public String toString() {
        return String.format("NoGenericMethods[arg1=%s, arg2=%s, arg3=%s]", arg1, arg2, arg3);
    }
}
