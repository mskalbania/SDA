public class Driver {
    private final String name;
    private final String surname;
    private final String workerId;

    public Driver(String workerId, String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.workerId = workerId;
    }

    public Driver(Driver driver){
        this.name = driver.getName();
        this.surname = driver.getSurname();
        this.workerId = driver.getWorkerId();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getWorkerId() {
        return workerId;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.surname.hashCode() + 1;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (object instanceof Driver) {
            if (this.surname.equals(((Driver) object).getSurname())) {
                return this.name.equals(((Driver) object).getName());
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return "Driver: ID -> " + this.getWorkerId() + " NAME -> " + this.getName() +
                " SURNAME -> " + this.getSurname();
    }

}
