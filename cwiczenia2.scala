object cwiczenia2 {
  def main(args: Array[String]): Unit = {

    println("Zadanie 2.1")
    def matchDay(day: String) = day match {
      case "Poniedzialek" | "Wtorek"| "Sroda" | "Czwartek" | "Piatek" => println("Praca")
      case "Sobota" | "Niedziela" => println("Weekend")
      case _ => println("Nie ma takiego dnia")
    }
    matchDay("Poniedzialek")
    matchDay("Niedziela")
    matchDay("Halo")
    println()

    println("Zadanie 2.2")
    class KontoBankowe(poczatkowyStanKonta: Double){
      private var _stanKonta: Double = poczatkowyStanKonta
      def stanKonta: Double = this._stanKonta

      def this(){
        this(0)
      }
      def wplata(ilosc: Double): Double ={
      _stanKonta += ilosc
        return _stanKonta
      }
      def wyplata(ilosc: Double): Unit = {
        if(_stanKonta < ilosc) return "Brak srodkow!"

        else _stanKonta -= ilosc
        return _stanKonta
      }
    }
    val kontoKlienta = new KontoBankowe
    val drugieKonto = new KontoBankowe(1212.12)
    kontoKlienta.wplata(123.12)
    println("Stan konta na poczatku: " + kontoKlienta.stanKonta)
    kontoKlienta.wyplata(23.23)
    println("Stan konta po wyplacie: " + kontoKlienta.stanKonta)
    println()
    drugieKonto.wplata(123.12)
    println("Stan drugiego konta na poczatku: " + drugieKonto.stanKonta)
    println()

    println("Zadanie 2.3")
    case class Osoba(imie: String, nazwisko: String){
    }
    val Kiwi = Osoba("Kiwi", "Ptakowoc")
    val Maja = Osoba("Maja", "Majowa")
    val Ula = Osoba("Ula", "Ulala")

    def przywitanie(osoba: Osoba) = osoba match{
      case Osoba("Kiwi","Ptakowoc") => "Oh, hi Kiwi!"
      case Osoba("Piotr", "Szypki") => "Nu"
      case Osoba("Maja", "Majowa") => "Hejka Maja!"
      case _ => "Witam uprzejmie!"
    }
    println(przywitanie(Kiwi))
    println(przywitanie(Maja))
    println(przywitanie(Ula))

    println()

    println("Zadanie 2.4")
    def wywolajTrzykrotnie( funkcja: Int => Int, wartosc: Int) = funkcja(funkcja(funkcja(wartosc)))
    def fajnaFuncja(wartosc: Int) = wartosc * 2
    println("To jest potrojne wywolanie funkcji: " + wywolajTrzykrotnie(fajnaFuncja, 3))
    println()

    println("Zadanie 2.5")
    class Osoba2(val imie: String, val nazwisko: String){
      val podatek = 0
    }
    trait Pracownik extends Osoba2 {
      override val podatek: Int = 20
      def pensja: Double
    }
    trait Student extends Osoba2{
      override val podatek: Int = 0
    }
    trait Nauczyciel extends Pracownik{
      override val podatek: Int = 10
    }

    val osoba1 = new Osoba2("Kiwi", "Ptakowoc") with Student
    println(s"Podatek dla studenta wynosi ${osoba1.podatek}%")

    val osoba2 = new Osoba2("Maja","Majowa") with Nauczyciel {
      override def pensja: Double = 10.10
    }
    println(s"Podatek nauczyciela wynosi ${osoba2.podatek}%")

    val osoba3 = new Osoba2("Kuba","Jakubowski") with Pracownik {
      override def pensja: Double = 15.15
    }
    println(s"Podatek pracownika wynosi ${osoba3.podatek}%")

    val osoba4 = new Osoba2("Kamil", "Kaminski") with Nauczyciel {
      override def pensja: Double = 20.20
    }
    println(s"Podatek nauczyciela wynosi ${osoba4.podatek}%")
    println()

    //Stwórz obiekty z traitami Student i Pracownik, pokaż jak podatek zadziała w zależności od kolejności w jakiej te traity zostały dodane przy tworzeniu obiektu.
    val osoba5 = new Osoba2("Kuba","Jakubowski") with Pracownik with Student {
      override def pensja: Double = 15.15
    }
    println(s"Podatek pracownika wynosi ${osoba5.podatek}%")

    val osoba6 = new Osoba2("Kiwi", "Ptakowoc") with Student with Pracownik {
      override def pensja: Double = 30.30
    }
    println(s"Podatek dla studenta wynosi ${osoba6.podatek}%")

  }
}
