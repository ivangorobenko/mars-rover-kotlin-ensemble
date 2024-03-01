import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MoveForwardTest {
    @ParameterizedTest
    @MethodSource("moveForwardParameters")
    fun `moves the rover forward for all directions`(
        direction: Direction,
        position: Position,
        expectedPosition: Position
    ) {
        val rover = Rover(direction, position)
        val roverThatMoved = rover.moveForward()
        Assertions.assertThat(roverThatMoved).isEqualTo(Rover(direction, expectedPosition))
    }

    companion object {
        @JvmStatic
        fun moveForwardParameters(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Direction.NORTH, Position(1, 7), Position(1, 6)),
                Arguments.of(Direction.SOUTH, Position(1, 7), Position(1, 8)),
                Arguments.of(Direction.EAST, Position(1, 7), Position(2, 7)),
                Arguments.of(Direction.WEST, Position(1, 7), Position(0, 7))
            )
        }
    }
}

