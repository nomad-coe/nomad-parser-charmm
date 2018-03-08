# CHARMM Parser
[NOMAD Laboratory CoE](http://nomad-coe.eu) parser for [CHARMM](https://www.charmm.org/charmm/)
## Version 0.0.1

This is the parser for CHARMM (Chemistry at HARvard Macromolecular Mechanics) code in [CHARMM](https://www.charmm.org/charmm/).

## Features
- All input and output files are expected to be in the supplied directory and its subdirectories.
- The parser searches for the main input file for extraction more information of the order of the commands and 
input CARDS. The main input file is assumed to hold at least 80% of the commands given to charmm main process.
- `MINI`, `DYNA`, `ENER`, `GETE`, `PRINT`, `OPEN`, `READ`, and `WRITE` commands can be prossesed with this parser.
- Any new `MINI`, `DYNA`, `ENER`, `GETE` commands are assumed to be a new simulation and each simulation is given in a new [section\_run](https://metainfo.nomad-coe.eu/nomadmetainfo_public/index.html#/public/section_run) in standardized meta information of NOMAD.
- Parser can extract topology information from **PSF**, **RTF**, **PAR** files and CARDS through MDDataAccess package. 
- **SEQ** CARDS can be read only for additional information if topology information is not complete.
- Additional topology information can also be extracted from **COOR**, **CRD** files(ascii) and CARDS.
- Input and output coordinates are mainly extracted from both ascii and binary **COOR** and **CRD** files/CARDS and 
`PRINT COOR` commands. 
...The coordinate information of the most recent command before any given command in the second item of this list is assumed to be the input coordinates of the simulation. Similarly, the next `PRINT`, `WRITE` command after each simulation is also assumed to be the output coordinates if trajectory data (`IUNCRD` or `IUNWRI` units) are missing. 
- Trajectory of the simulations are also accessed through MDDataAccess package of [python-common](https://gitlab.rzg.mpg.de/nomad-lab/python-common).

## Download and Installation
The official version lives at:

    git@gitlab.mpcdf.mpg.de:nomad-lab/parser-charmm.git

You can browse it at:

    https://gitlab.rzg.mpg.de/nomad-lab/parser-charmm

It relies on having the nomad-meta-info and the python-common repositories one level higher.
The simplest way to have this is to check out nomad-lab-base recursively:

    git clone --recursive git@gitlab.mpcdf.mpg.de:nomad-lab/nomad-lab-base.git

This parser will be in the directory parsers/charmm of this repository.

## Running and Testing the Parser
### Requirements
The required python packages can be installed with (see [python-common](https://gitlab.rzg.mpg.de/nomad-lab/python-common)):

    pip install -r nomad-lab-base/python-common/requirements.txt

### Usage
CHARMM MD log output files can be parsed with:

    python CHARMMParser.py [path/toFile]

### Test Files
Example log output files of CHARMM can be found in the directory test/examples.
More details about the calculations and files are explained in the README file under examples directory.

