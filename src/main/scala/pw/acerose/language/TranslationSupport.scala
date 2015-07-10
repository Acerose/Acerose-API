package pw.acerose.language

/**
 * Provides short-hand support for translating strings in addition to a functional API for translation
 * and implicit conversions from translation keys to a string
 */
trait TranslationSupport {

    final type TString = TranslationKey

    /**
     * Provides the `t"string"` decorator for strings.
     * Input is processed by the `s"interpolator"` before a [[TranslationKey]] is computed
     */
    implicit class StringDecorators(private val context: StringContext) extends AnyVal {

        def t(parts: Any*): TString = new TranslationKey(context.s(parts:_*))

    }

    /**
     * Defines the coercion procedure when a key might be used in place of a string
     */
    implicit def TranslationKeyToString(key: TString)
                                       (implicit context: TranslateLocale = TranslateLocale.DefaultLocale): String = {
        key.translated(context)
    }

}

object TranslationSupport extends AnyRef with TranslationSupport
