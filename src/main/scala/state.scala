import scala.collection.mutable.{ArrayBuffer}

class State {
    private var cells: ArrayBuffer[Int] = new ArrayBuffer[Int];
    private var pc: Int = 0;

    cells += 0;

    //! Operates on the value of the current cell.
    def decrement = { cells(pc) -= 1; }
    def increment = { cells(pc) += 1; }

    //! Operates on the PC.
    def retreat(value: Int) = { pc -= value; }
    def advance(value: Int) = {
        pc += value;

        //! Resize the cells.
        if (pc >= cells.size)
            cells += 0;
    }

    //! Operates on the current value of the cell.
    def value = { cells(pc); }
    def out = { print(cells(pc).toChar); }
}
