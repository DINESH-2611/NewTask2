import Demo.Gender
import Demo.Hero

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
//    val heroes = listOf(
//        Hero("The Captain", 60, Gender.MALE),
//        Hero("Frenchy", 42, Gender.MALE),
//        Hero("The Kid", 9, null),
//        Hero("Lady Lauren", 29, Gender.FEMALE),
//        Hero("First Mate", 29, Gender.MALE),
//        Hero("Sir Stephen", 37, Gender.MALE))
//
//    val mapByAge: Map<Int, List<Hero>> =
//        heroes.groupBy { it.age }
//    val (age, group) = mapByAge.maxBy { (_, group) ->
//        group.size
//    }!!
//    println(age)
    val heroes = listOf(
        Hero("The Captain", 60, Gender.MALE),
        Hero("Frenchy", 42, Gender.MALE),
        Hero("The Kid", 9, null),
        Hero("Lady Lauren", 29, Gender.FEMALE),
        Hero("First Mate", 29, Gender.MALE),
        Hero("Sir Stephen", 37, Gender.MALE))

//    val mapByName: Map<String, Hero> =
//        heroes.associateBy { it.name }
//    println(mapByName["Frenchy"]?.age)


//    val mapByName = heroes.associate{ it.name to it.age }
////    println(mapByName)
////    val unknownHero = Hero("Unknown", 0, null)
//    println(mapByName.getOrElse("unknown") { 0})

    val (first, second) = heroes
        .flatMap { heroes.map { hero -> it to hero } }
        .maxBy { it.first.age - it.second.age }!!
    println(first.name)
}