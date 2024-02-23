import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class MoveForwardTest {

    @Test
    fun `moves the rover forward when facing north`() {
        val rover = Rover(Direction.NORTH, Position(1, 7))
        val roverThatMoved = rover.execute(MoveForward())
        Assertions.assertThat(roverThatMoved).isEqualTo(Rover(Direction.NORTH, Position(1, 6)))
    }

    @Test
    fun `moves the rover forward when facing south`() {
        val rover = Rover(Direction.SOUTH, Position(1, 7))
        val roverThatMoved = rover.execute(MoveForward())
        Assertions.assertThat(roverThatMoved).isEqualTo(Rover(Direction.SOUTH, Position(1, 8)))
    }
}

class MoveForward {
    fun compute(position: Position, direction: Direction): Position {

        if (direction == Direction.SOUTH) return position.moveSouth()
        return position.moveNorth()
    }
}

data class Position(val x: Int, val y: Int) {
    fun moveSouth(): Position {
        return Position(x, y + 1)
    }

    fun moveNorth(): Position {
        return Position(x, y - 1)
    }
}

enum class Direction {
    NORTH, SOUTH, EAST, WEST
}

data class Rover(val direction: Direction, val position: Position) {
    fun execute(moveForward: MoveForward): Rover {
        return Rover(this.direction, moveForward.compute(position, direction))
    }

}
