#
# Copyright The NOMAD Authors.
#
# This file is part of NOMAD. See https://nomad-lab.eu for further info.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

import pytest

from nomad.datamodel import EntryArchive
from charmmparser import CharmmParser


def approx(value, abs=0, rel=1e-6):
    return pytest.approx(value, abs=abs, rel=rel)


@pytest.fixture(scope='module')
def parser():
    return CharmmParser()


def test_basic(parser):
    archive = EntryArchive()

    parser.parse('tests/data/brbtest/brbtest.out', archive, None)

    sec_run = archive.section_run[0]
    assert sec_run.program_version == 'Free Version 41b2   February 15, 2017'

    sec_system = archive.section_run[0].section_system[0]
    assert sec_system.atom_labels[1] == 'C'
    assert sec_system.atom_positions[10][1].magnitude == approx(-7.7269e-11)

    sec_scc = sec_run.section_single_configuration_calculation[0]
    assert sec_scc.energy_total.magnitude == approx(8.37550246e-20)


def test_1(parser):
    archive = EntryArchive()

    parser.parse('tests/data/enertest/enertest.out', archive, None)

    sec_system = archive.section_run[0].section_system[0]
    assert len(sec_system.atom_positions) == 580
    assert sec_system.atom_labels[86] == 'O'
    assert sec_system.atom_positions[11][1].magnitude == approx(-4.005e-10)

    sec_sccs = archive.section_run[0].section_single_configuration_calculation
    assert sec_sccs[6].energy_total.magnitude == approx(-2.31823331e-18)
