import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class MoveForwardTest {

    @Test
    fun `moves the rover forward when facing north`() {
        val rover = Rover(Direction.NORTH, Position(1, 7))
        val roverThatMoved = rover.execute(MoveForward())
        Assertions.assertThat(roverThatMoved).isEqualTo(Rover(Direction.NORTH, Position(1, 6)))
    }
}

class MoveForward {
    fun compute(position: Position) = Position(position.x, position.y - 1)
}

data class Position(val x: Int, val y: Int)
enum class Direction {
    NORTH, SOUTH, EAST, WEST
}

data class Rover(val direction: Direction, val position: Position) {
    fun execute(moveForward: MoveForward): Rover {
        return Rover(this.direction, moveForward.compute(position))
    }

}
