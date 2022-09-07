import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.*

@ExtendWith(MockitoExtension::class)
class MockitoTest {

    private val car1: Car = mock()

    private val car2: Car = mock()

    private val car3: Car = mock {
        on { drive(any()) } doReturn OutCome.OK
    }

    private val car4 = spy(Car())

    @InjectMocks
    private val sut = TrafficSystem()

    @Test
    fun test() {
        // given
        whenever(car1.drive(Direction.NORTH)).thenReturn(OutCome.OK)
        // when
        sut.doAction()
        // then
        verify(car1, times(1)).drive(any())
    }
}
