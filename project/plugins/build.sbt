resolvers ++= Seq(
  "Web plugin repo" at "http://siasia.github.com/maven2",
  Resolver.url("Typesafe repository", new java.net.URL("http://typesafe.artifactoryonline.com/typesafe/ivy-releases/"))(Resolver.defaultIvyPatterns)
)

libraryDependencies <+= sbtVersion(v => "com.github.siasia" %% "xsbt-web-plugin" % ("0.1.0-"+v))

resolvers += {
    val typesafeRepoUrl = new java.net.URL("http://repo.typesafe.com/typesafe/ivy-snapshots")
    val pattern = Patterns(false, "[organisation]/[module]/[sbtversion]/[revision]/[type]s/[module](-[classifier])-[revision].[ext]")
    Resolver.url("Typesafe Ivy Snapshot Repository", typesafeRepoUrl)(pattern)
}

libraryDependencies <<= (libraryDependencies, sbtVersion) { (deps, version) =>
    deps :+ ("com.typesafe.startscript" %% "xsbt-start-script-plugin" % "0.1-SNAPSHOT" extra("sbtversion" -> version))
}

