//  Copyright (C) 2012  Konstantin Mandrika
//
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
//
//  You should have received a copy of the GNU General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.

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
