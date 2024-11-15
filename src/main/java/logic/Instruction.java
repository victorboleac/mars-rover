package logic;

public enum Instruction {
    L, R, M;
    public static Instruction fromChar(char c){
        try {
            return Instruction.valueOf(String.valueOf(c).toUpperCase());
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Invalid Instruction: " + c);
        }
    }
}
