# Copyright 2018-2018 Berk Onat
# 
#   Licensed under the Apache License, Version 2.0 (the "License");
#   you may not use this file except in compliance with the License.
#   You may obtain a copy of the License at
# 
#     http://www.apache.org/licenses/LICENSE-2.0
# 
#   Unless required by applicable law or agreed to in writing, software
#   distributed under the License is distributed on an "AS IS" BASIS,
#   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#   See the License for the specific language governing permissions and
#   limitations under the License.

from parmed.charmm import CharmmParameterSet
import parmed as pmd
import sys

if __name__ == "__main__":
    pfile=sys.argv[1]
    sfile=None
    if len(sys.argv)>2:
        sfile=sys.argv[2]
    if sfile:
        psf = pmd.load_file(sfile)
        print(len(psf.atoms))
    #params = CharmmParameterSet('toph8.rtf', 'param3.prm')
    if sfile:
        params = CharmmParameterSet.from_structure(psf)
    else:
        params = CharmmParameterSet()
    print(len(psf.atoms))
    #params.read_parameter_file('../../../data/par_all27_prot_lipid_chiral.dat')
    params.read_parameter_file(pfile)
    print(params)
    print(params.atom_types)
    print('%.4f' % (params.atom_types['CD'].epsilon))
    print('%.4f' % (params.atom_types['CD'].rmin))
    print('%.4f' % (params.atom_types['NH3'].epsilon))
    print('%.4f' % (params.atom_types['NH3'].rmin))
    #print(params.bond_types)
    #print(params.angle_types)
    #print(params.dihedral_types)
