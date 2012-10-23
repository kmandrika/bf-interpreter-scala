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
