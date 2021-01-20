/*
 * Copyright The NOMAD Authors.
 *
 * This file is part of NOMAD.
 * See https://nomad-lab.eu for further info.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.nomad_lab.parsers

import org.specs2.mutable.Specification

object CharmmParserTests extends Specification {
  "CharmmParserTest" >> {
    //    "[MINI brbtest] test with json-events" >> {
    //      ParserRun.parse(CharmmParser, "parsers/charmm/test/examples/brbtest/brbtest.out", "json-events") must_== ParseResult.ParseSuccess
    //    }
    //    "[MINI brbtest] test with json" >> {
    //      ParserRun.parse(CharmmParser, "parsers/charmm/test/examples/brbtest/brbtest.out", "json") must_== ParseResult.ParseSuccess
    //    }
    //    "[DYNA dyntest1] test with json-events" >> {
    //      ParserRun.parse(CharmmParser, "parsers/charmm/test/examples/dyntest1/dyntest1.out", "json-events") must_== ParseResult.ParseSuccess
    //    }
    //    "[DYNA dyntest1] test with json" >> {
    //      ParserRun.parse(CharmmParser, "parsers/charmm/test/examples/dyntest1/dyntest1.out", "json") must_== ParseResult.ParseSuccess
    //    }
    //    "[LANGEVIN dyntest2] test with json-events" >> {
    //      ParserRun.parse(CharmmParser, "parsers/charmm/test/examples/dyntest2/dyntest2.out", "json-events") must_== ParseResult.ParseSuccess
    //    }
    //    "[LANGEVIN dyntest2] test with json" >> {
    //      ParserRun.parse(CharmmParser, "parsers/charmm/test/examples/dyntest2/dyntest2.out", "json") must_== ParseResult.ParseSuccess
    //    }
    //    "[langtest1] test with json-events" >> {
    //      ParserRun.parse(CharmmParser, "parsers/charmm/test/examples/langtest1/langtest1.out", "json-events") must_== ParseResult.ParseSuccess
    //    }
    //    "[langtest1] test with json" >> {
    //      ParserRun.parse(CharmmParser, "parsers/charmm/test/examples/langtest1/langtest1.out", "json") must_== ParseResult.ParseSuccess
    //    }
    //    "[nose1] test with json-events" >> {
    //      ParserRun.parse(CharmmParser, "parsers/charmm/test/examples/nose1/nose1.out", "json-events") must_== ParseResult.ParseSuccess
    //    }
    //    "[nose1] test with json" >> {
    //      ParserRun.parse(CharmmParser, "parsers/charmm/test/examples/nose1/nose1.out", "json") must_== ParseResult.ParseSuccess
    //    }
    "[tip4ptest] test with json-events" >> {
      ParserRun.parse(CharmmParser, "parsers/charmm/test/examples/tip4ptest/tip4ptest.out", "json-events") must_== ParseResult.ParseSuccess
    }
    "[tip4ptest] test with json" >> {
      ParserRun.parse(CharmmParser, "parsers/charmm/test/examples/tip4ptest/tip4ptest.out", "json") must_== ParseResult.ParseSuccess
    }
  }
}
