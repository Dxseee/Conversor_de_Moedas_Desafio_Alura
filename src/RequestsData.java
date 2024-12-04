public record RequestsData(String base_code, String target_code, double conversion_rate, double conversion_result) {
    private static double ammount = 0;

    public static double getAmmount() {
        return ammount;
    }

    public static void setAmmount(double ammount) {
        RequestsData.ammount = ammount;
    }

    @Override
    public String toString() {
        return String.format("Valor %f [%s] corresponde ao valor final de =>>> %f [%s] ",getAmmount(),base_code,conversion_result, target_code);
    }
}
