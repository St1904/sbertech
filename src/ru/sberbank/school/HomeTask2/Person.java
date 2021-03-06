package ru.sberbank.school.HomeTask2;

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
        if (person != null && this.man != person.man && (this.spouse == null || !this.spouse.equals(person))) {
            this.divorce();
            person.divorce();
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
            if (spouse.spouse != null)
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

        //as shorter alternative approach
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

        //as shorter alternative approach
        //return Objects.hash(man, name, spouse);

        return result;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Person manIgor = new Person(true, "Igor");
        if (manIgor.marry(null)) {
            System.out.println("ERROR");
        }
        Person womanOlga = new Person(false, "Olga");
        System.out.println(manIgor.marry(womanOlga));
        System.out.println(manIgor.getSpouse());
        System.out.println(womanOlga.getSpouse());

        System.out.println();
        Person womanOxana = new Person(false, "Oxana");
        System.out.println(womanOlga.marry(womanOxana));
        System.out.println(womanOlga.getSpouse());
        System.out.println(womanOxana.getSpouse());

        System.out.println();
        System.out.println(manIgor.marry(womanOxana));
        System.out.println(manIgor.getSpouse());
        System.out.println(womanOlga.getSpouse());
        System.out.println(womanOxana.getSpouse());

        System.out.println();
        System.out.println(manIgor.divorce());
        System.out.println(manIgor.getSpouse());
        System.out.println(womanOxana.getSpouse());

    }
}

//    Person manIgor = new Person(true,"Igor");
//        if(manIgor.marry(null)){
//                System.out.println("ERROR: manIgor.marry(null)");
//                }
