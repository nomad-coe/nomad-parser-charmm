package eu.nomad_lab.parsers

import eu.nomad_lab
import eu.nomad_lab.DefaultPythonInterpreter
import org.{ json4s => jn }
import eu.{ nomad_lab => lab }
import scala.collection.breakOut

object CharmmParser extends SimpleExternalParserGenerator(
  name = "CharmmParser",
  parserInfo = jn.JObject(
    ("name" -> jn.JString("CharmmParser")) ::
      ("parserId" -> jn.JString("CharmmParser" + lab.CharmmVersionInfo.version)) ::
      ("versionInfo" -> jn.JObject(
        ("nomadCoreVersion" -> jn.JObject(lab.NomadCoreVersionInfo.toMap.map {
          case (k, v) => k -> jn.JString(v.toString)
        }(breakOut): List[(String, jn.JString)])) ::
          (lab.CharmmVersionInfo.toMap.map {
            case (key, value) =>
              (key -> jn.JString(value.toString))
          }(breakOut): List[(String, jn.JString)])
      )) :: Nil
  ),
  mainFileTypes = Seq("text/.*"),
  mainFileRe = """\s*Chemistry\s*at\s*HARvard\s*Macromolecular\s*Mechanics\s*""".r,
  cmd = Seq(DefaultPythonInterpreter.pythonExe(), "${envDir}/parsers/charmm/parser/parser-charmm/CHARMMParser.py",
    "${mainFilePath}"),
  resList = Seq(
    "parser-charmm/CHARMMParser.py",
    "parser-charmm/CHARMMDictionary.py",
    "parser-charmm/CHARMMCommon.py",
    "parser-charmm/setup_paths.py",
    "nomad_meta_info/public.nomadmetainfo.json",
    "nomad_meta_info/common.nomadmetainfo.json",
    "nomad_meta_info/meta_types.nomadmetainfo.json"
    "nomad_meta_info/charmm.nomadmetainfo.json"
  ) ++ DefaultPythonInterpreter.commonFiles(),
  dirMap = Map(
    "parser-charmm" -> "parsers/charmm/parser/parser-charmm",
    "nomad_meta_info" -> "nomad-meta-info/meta_info/nomad_meta_info",
    "python" -> "python-common/common/python/nomadcore"
  ) ++ DefaultPythonInterpreter.commonDirMapping(),
  metaInfoEnv = Some(lab.meta.KnownMetaInfoEnvs.charmm)
)

