class TrafficSystem {

    lateinit var car1: Car

    lateinit var car2: Car

    lateinit var car3: Car

    fun doAction() {
        car1.drive(Direction.NORTH)
        car2.drive(Direction.EAST)
        car3.drive(Direction.SOUTH)
    }
}
