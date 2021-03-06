package level_24.LocalClass.t2;

import java.util.Date;

/*
В работе вам иногда будет нужно закастить класс к какому-нибудь другому классу, не интерфейсу :)))
Класс DogPet использует 2 класса - SuperDog и Dog, разберись с getName в классе DogPet
Так намного лучше, чем Copy+Paste!
 */
public class Dog implements Pet {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    /**
     * Если так получилось, что есть готовый класс А (тут SuperDog) с логикой, которую вы хотите использовать.
     * То возможны 3 способа:
     * 1) из класса А скопировать логику себе (это плохо, т.к. поддерживать несколько копий одного и того же кода проблематично)
     * 2) создать экземплр класса А внутри нашего класса и использовать его, свзь has-a (не всегда подходит, т.к. класс А сам по себе)
     * 3) создать внутренний класс, который наследуетс от А, использовать его методы вместе с
     * методами и полми нашего класса, т.к. внутренний класс имеет доступ к своему родителю как наследник,
     * а также ко всем полм и методам включа private того класса, в который он вложен.
     * <p/>
     * Итак, разбираемс с п.3:
     * Внутри метода toSayable создайте class DogPet, который наследуетс от SuperDog и реализует интерфейс Sayable
     * создайте метод private String getName(), который будет использовать логику двух классов - Dog и SuperDog.
     * Пусть этот метод возвращает им собаки (класс Dog), которое с обеих сторон выделено getSuperQuotes (класс SuperDog)
     * Пример, " *** Барбос *** "
     * Логика метода say:
     * Если i < 1, то использу метод getName вывести на экран, что собака спит. Пример, " *** Шарик ***  спит."'
     * Иначе вывести фразу: "им_собаки лает гааав! сегодншн_дата". Пример дл i=3, " *** Тузик ***  лает гааав! 13-но-2013 Ср"
     * Дл форматировани даты используйте formatter из класса SuperDog.
     * <p/>
     * <b>Пример вывода:</b>
     * *** Барбос ***  лает гааааав! 13-но-2013 Ср
     * *** Тузик ***  лает гаав! 13-но-2013 Ср
     * *** Бобик ***  лает гааав! 13-но-2013 Ср
     * Мышь пищит.
     * *** Шарик ***  спит.
     *
     * @param i количество букв 'а' в слове гав
     * @return экземплр класса DogPet
     */
    public Sayable toSayable(final int i) {
        class DogPet extends SuperDog implements Sayable {
            @Override
            protected String getSuperQuotes() {
                return super.getSuperQuotes();
            }

            @Override
            public String say() {
               if (i < 1) return (getName() + " спит.");
               else {
                   StringBuilder builder = new StringBuilder(getName() + " лает г");
                   for (int j = 0; j < i; j++) {
                       builder.append('а');
                   }
                   builder.append("в! ");
                   builder.append(formatter.format(new Date()));
                   return builder.toString();
               }
            }

            private String getName() {
                return getSuperQuotes() + name + getSuperQuotes();
            }
        }
        return new DogPet();
    }
}