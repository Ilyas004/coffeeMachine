package rab

class coffeeMachine(waterK: Int = 0, milkK: Int = 0, cofBeansK: Int = 0, cupsCofK: Int, moneyK: Int = 0) {
    private var water = waterK
    private var milk = milkK
    private var cofBeans = cofBeansK
    private var cupsCof = cupsCofK
    private var money = moneyK

    fun actionCofMachine(action: String) {
        when (action) {
            "buy" -> buyCoffe()
            "fill" -> fillCofMachine()
            "take" -> takeMoney()
            "remaining" -> remaining()
        }
    }

    fun buyCoffe() {
        print("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: > ")
        when (readln()) {
              "1" -> {
                if (water - 250 >= 0 && cofBeans - 16 >= 0 && cupsCof - 1 >= 0) {
                    water -= 250
                    cofBeans -= 16
                    money += 4
                    cupsCof--
                    println("I have enough resources, making you a coffee!\n")
                } else println("Sorry, not enough water!\n")
            }
            "2" -> {
                if (water - 350 >= 50 && milk - 75 >= 0 && cofBeans - 20 >= 0 && cupsCof - 1 >= 0) {
                    water -= 350
                    milk -= 75
                    cofBeans -= 20
                    money += 7
                    cupsCof--
                    println("I have enough resources, making you a coffee!\n")
                } else println("Sorry, not enough water!\n")

            }
            "3" -> {
                if (water - 200 >= 0 && milk - 100 >= 0 && cofBeans - 12 >= 0 && cupsCof - 1 >= 0) {
                    water -= 200
                    milk -= 100
                    cofBeans -= 12
                    money += 6
                    cupsCof--
                    println("I have enough resources, making you a coffee!\n")
                } else println("Sorry, not enough water!\n")
            }
            "back" -> println()
        }
    }

    fun fillCofMachine() {
        print("\nWrite how many ml of water do you want to add: > ")
        val needWater = readln().toInt()
        print("Write how many ml of milk do you want to add: > ")
        val needMilk = readln().toInt()
        print("Write how many grams of coffee beans do you want to add: > ")
        val needBeans = readln().toInt()
        print("Write how many disposable cups of coffee do you want to add: > ")
        val needCups = readln().toInt()
        water += needWater
        milk += needMilk
        cofBeans += needBeans
        cupsCof += needCups
        println()
    }

    fun takeMoney() {
        println("\nI gave you $$money\n")
        money = 0
    }

    fun remaining() {
        println("\nThe coffee machine has:")
        println("$water ml of water")
        println("$milk ml of milk")
        println("$cofBeans g of coffee beans")
        println("$cupsCof disposable cups")
        println("$$money of money\n")
    }

    fun menuMachine() = print("Write action (buy, fill, take, remaining, exit): > ")
}

fun main() {
    val cofMac = coffeeMachine(400, 540, 120, 9)
    cofMac.menuMachine()
    var action = readln()
    while (action != "exit") {
        cofMac.actionCofMachine(action)
        cofMac.menuMachine()
        action = readln()
    }
}