import scala.collection.mutable.{ArrayBuffer}
import scala.collection.mutable.{Stack}

class Evaluate(program: String) {
    def result = {
        var state: State = new State;
        var table: Table = new Table(program);
        var index: Int = 0;

        while (index != program.size) {
            program(index) match {
                case '>' => state.advance(1);
                case '<' => state.retreat(1);
                case '+' => state.increment;
                case '-' => state.decrement;
                case '.' => state.out;
                case ',' => null;
                case '[' => if (state.value == 0) index = table.at(index);
                case ']' => if (state.value != 0) index = table.at(index);
                case  _  => null;
            }

            index += 1;
        }
    }
}
