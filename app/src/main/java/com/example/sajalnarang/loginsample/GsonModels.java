package com.example.sajalnarang.loginsample;

public class GsonModels {

    public class UserDetails {
        private String name;
        private String rollno;
        private String email;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRollno() {
            return rollno;
        }

        public void setRollno(String rollno) {
            this.rollno = rollno;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public UserDetails(String name, String rollno, String email) {

            this.name = name;
            this.rollno = rollno;
            this.email = email;
        }
    }
}
