import java.util.Objects;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public boolean isMan() {
        return man;
    }

    public String getName() {
        return name;
    }

    public Person getSpouse() {
        return spouse;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife. Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     *
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */
    public boolean marry(Person person) {
        if (!(person == null) && this.man != person.man && !this.spouse.equals(person)) { //TODO: null pointer
            if (this.spouse != null) { // TODO: extra condition
                this.divorce();
            }
            if (person.spouse != null) { // TODO: extra condition
                person.divorce();
            }
            this.spouse = person;
            person.spouse = this;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sets spouse = null if spouse is not null
     *
     * @return true - if person status has been changed
     */
    public boolean divorce() {
        if (spouse != null) {
            spouse.spouse = null;
            spouse = null;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        //TODO: as shorter alternative approach
//        return Objects.equals(man, person.man)
//                && Objects.equals(name, person.name)
//                && Objects.equals(spouse, person.spouse);

        if (man != person.man) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (spouse != null ? !spouse.equals(person.spouse) : person.spouse != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (man ? 1 : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (spouse != null ? spouse.hashCode() : 0);

        //TODO: as shorter alternative approach
        //return Objects.hash(man, name, spouse);

        return result;
    }
}

//    //TODO: adequate checks are needed.
//    //TODO: like this:
//    Person manIgor = new Person(true,"Igor");
//        if(manIgor.marry(null)){
//                System.out.println("ERROR: manIgor.marry(null)");
//                }
