data class Rover(val direction: Direction, val position: Position) {
    fun execute(moveForward: MoveForward): Rover {
        return Rover(this.direction, moveForward.compute(position, direction))
    }

}