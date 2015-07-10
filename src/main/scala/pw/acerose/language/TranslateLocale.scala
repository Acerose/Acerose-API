package pw.acerose.language

import grizzled.slf4j.Logging

/**
 * Interface to a translation table.
 */
trait TranslateLocale {

    /**
     * Translate a translation key to a phrase, optionally formatting it with the folloing
     * format parameters
     *
     * @param key           Format key
     * @param formatParams  Format parameters
     * @return              Phrase
     */
    def translate(key: String, formatParams: Seq[Any] = Nil): String

}

object TranslateLocale extends AnyRef with Logging {

    /**
     * Default locale that nags developers and hosts and then spits out the raw key post-formatting
     */
    object DefaultLocale extends AnyRef with TranslateLocale {

        def translate(key: String, formatParams: Seq[Any] = Nil): String = {
            warn(
                """
                  |There is no logging plugin configured for the current context.
                  |You should configure your plugin or server correctly, as you are otherwise
                  |a terrible person.
                  |Whatever you input as a translation key will be used directly.
                  |This message can not be disabled, and will appear every time you attempt
                  |to translate a non-existent key.
                """.stripMargin)

            key.format(formatParams:_*)
        }

    }

}
