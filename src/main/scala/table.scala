import scala.collection.mutable.{ArrayBuffer}
import scala.collection.mutable.{Stack}

class Table(program: String) {
    private var table: ArrayBuffer[Int] = new ArrayBuffer[Int];

    private var paren: Stack[Int] = new Stack[Int];
    private var i: Int = 0;

    program map { _ match {
        case '[' => { table += 0; paren.push(i); i += 1; }
        case ']' => { table += 0; table(i) = paren.pop; table(table(i)) = i; i += 1; }
        case  _  => { table += 0; i += 1; }
    }}

    def at(index: Int) = {
        table(index);
    }
}