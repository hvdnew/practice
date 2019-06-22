package chk;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionMain {

//    The records should be grouped by Country and gender (refer Sample_Output.csv).
//    Note: City should be used where country is not available.


    public static void main(String[] args) {


        Collection<IncomeData> data = new ArrayList<>(10);

        data.add(new IncomeData("GGN", "IND", "M", "INR", 20000l));
        data.add(new IncomeData("GGN", "IND", "F", "INR", 20000l));
        data.add(new IncomeData("SURAT", "IND", "M", "INR", 20000l));
        data.add(new IncomeData("SURAT", "IND", "F", "INR", 20000l));
        data.add(new IncomeData("SURAT", "IND", "M", "INR", 20000l));
        data.add(new IncomeData("GGN", "IND", "F", "INR", 20000l));
        data.add(new IncomeData("JAIPUR", "IND", "M", "INR", 20000l));
        data.add(new IncomeData("JAIPUR", "IND", "M", "INR", 20000l));
        data.add(new IncomeData("GGN", "IND", "F", "INR", 20000l));
        data.add(new IncomeData(null, "LND", "M", "POUND", 2000l));
        data.add(new IncomeData(null, "LND", "M", "POUND", 2000l));


    }


    private static final class IncomeData {

        private String city;
        private String country;
        private String gender;
        private String currrency;
        private Long income;

        public IncomeData(String city, String country, String gender, String currrency, Long income) {
            this.city = city;
            this.country = country;
            this.gender = gender;
            this.currrency = currrency;
            this.income = income;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getCurrrency() {
            return currrency;
        }

        public void setCurrrency(String currrency) {
            this.currrency = currrency;
        }

        public Long getIncome() {
            return income;
        }

        public void setIncome(Long income) {
            this.income = income;
        }

        @Override
        public String toString() {
            return "IncomeData [city=" + city + ", country=" + country + ", gender=" + gender + ", currrency=" + currrency
                    + ", income=" + income + "]";
        }


    }


}
