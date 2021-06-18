import scala.annotation.tailrec

object cwczenia1 {
    def main(args: Array[String]): Unit = {
      println("Zadanie 1.1")
      var i = 0
      val listaDniTyg = List("Poniedzialek", "Wtorek", "Sroda", "Czwartek", "Piatek", "Sobota", "Niedziela")

      def TworzListeA(): Unit = {
        val mojaListaA = for (i <- listaDniTyg)
          print(i + ", ")
      }
      TworzListeA()
      println()

      def TworzListeB(): Unit = {
        val mojaListaB = for (i <- listaDniTyg) {
          if (i.startsWith("P")) print(i + ", ")
        }
      }
      TworzListeB()
      println()

      //      def TworzListeB2(): Unit ={
      //        val mojaListaB2 = for(i <- listaDniTyg) {
      //          if (i.charAt(0) == "P".toCharArray.head) {
      //            print(i + ", ")
      //          }
      //        }
      //      }
      //      TworzListeB2()
      //      println()

      def TworzListeC(): Unit = {
        val mojaListaC = listaDniTyg.iterator
        while (mojaListaC.hasNext) {
          print(mojaListaC.next() + ", ")
        }
      }
      TworzListeC()
      println()
      println()

//      println("Zadanie 2")
//      def TworzListeRekA(days : List[String]): Unit = {
//        for(i <- days)
//          if (days.last != i)
//            TworzListeRekA(List(i))
//          else print(i + ", ")
//        }
//      TworzListeRekA(listaDniTyg)
//      println()

      println("Zadanie 1.2")
      def TworzListeRekA(days : List[String]): String = {
        if (days.isEmpty) ""
        else days.head + ", " + TworzListeRekA(days.tail)
      }
      println(TworzListeRekA(listaDniTyg))

      def TworzListeRekB(days: List[String]): String = {
        if(days.isEmpty) ""
        else TworzListeRekB(days.tail) + days.head + ", "
      }
      println(TworzListeRekB(listaDniTyg))
      println()

      println("Zadanie 1.3")
      def TworzListeRekOgon(days: List[String]): String = {
        @tailrec
        def iter(day: List[String], result: String): String =
          if(day.isEmpty) result
          else iter(day.tail, result + day.head + ", ")
        iter(days, "")
      }
      println(TworzListeRekOgon(listaDniTyg))
      println()

      println("Zadanie 1.4")
      def TworzListeFoldA(days: List[String]): String = {
        days.foldLeft("")(_ + ", " + _)
      }
      println(TworzListeFoldA(listaDniTyg))
      println()

      def TworzListeFoldB(days: List[String]): String = {
        days.foldRight("")(_ + ", " + _)
      }
      println(TworzListeFoldB(listaDniTyg))
      println()

//      def TworzListeFoldC(days: List[String]): String = {
//        days.foldLeft("")({ (day1: String, day2: String) =>
//          s"${day1}${if(day2.startsWith("P")) s"${day2}, " else ""}"
//        })
//      }
//      println(TworzListeFoldC(listaDniTyg))
//      println()

      def TworzListeFoldC2(days: List[String]): String = {
        days.foldLeft("")({ (day1: String, day2: String) =>
          (day1 + {if(day2.startsWith("P")) day2 + ", " else ""})
        })
      }
      println(TworzListeFoldC2(listaDniTyg))
      println()

      println("Zadanie 1.5")
      val listaProduktow: Map[String, Double] = Map("mleko" -> 3.5, "kiwi" -> 2.5, "platki" -> 11, "kawa" -> 34)
      def ObnizkaCen(zakupy: Map[String, Double], obnizka: Double): Map[String, Double] = {
        zakupy map (x => (x._1, x._2 * ((1-(obnizka/100)))))
      }
      println(ObnizkaCen(listaProduktow, 10))
      println()

      println("Zadanie 1.6")
      val t = Tuple3("Hej", 122, "Kiwi")
      def wypiszWartosci(krotka: Tuple3[String, Int, String]): Unit ={
        println(krotka._1 + krotka._2 + krotka._3)
      }
      println(wypiszWartosci(t))
      println()

      println("Zadanie 1.7")
      def wypiszOpcje(mapa: Map[String, Double]) = {
        println("produkt pierwszy kosztuje: " + mapa.get("mleko"))
        println("produkt piaty kosztuje: " + mapa.get("chleb"))
      }
      wypiszOpcje(listaProduktow)
      println()

      println("Zadanie 1.8")
      val listaZer = List(1,2,0,-4,0, -2, 0, -10)
      def usunZeraZListy(lista: List[Int]): List[Int] = lista match {
        case Nil => Nil
        case head :: tail => if (head == 0) usunZeraZListy(tail) else head :: usunZeraZListy(tail)
      }
      println("Lista z zerami: " + listaZer)
      println("Lista bez zer: " + usunZeraZListy(listaZer))
      println()

      println("Zadanie 1.9")
      def powiekszListe(listaMala: List[Int]): List[Int] = {
        listaMala.map(_ + 1)
      }
      println(powiekszListe(listaZer))
      println()

      println("Zadanie 1.10")
      val listaRzeczywista = List(2.31, -1.2, 0, 1, -15, 12 )
      def filtrujListe(listaujemna: List[Double]): List[Double] = {
        listaujemna filter (_ > 0)
      }
      println(filtrujListe(listaRzeczywista))
      println()
    }
  }
