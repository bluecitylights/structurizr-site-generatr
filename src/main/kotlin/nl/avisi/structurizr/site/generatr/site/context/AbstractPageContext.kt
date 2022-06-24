package nl.avisi.structurizr.site.generatr.site.context

import nl.avisi.structurizr.site.generatr.site.makeUrlRelative
import java.io.File

abstract class AbstractPageContext(val generatorContext: GeneratorContext, val title: String, val htmlFile: String) {
    val workspace get() = generatorContext.workspace
    val branches get() = generatorContext.branches
    val urlPrefix get() = "/${generatorContext.currentBranch}"
    val url: String

    fun urlRelativeTo(sourceContext: AbstractPageContext): String {
        return makeUrlRelative(url, sourceContext.url)
    }

    init {
        val parent = File(htmlFile).parent
        url = if (parent == null) urlPrefix else "$urlPrefix/$parent/"
    }
}
