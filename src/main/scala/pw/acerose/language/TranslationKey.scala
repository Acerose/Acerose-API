package pw.acerose.language

/**
 * A translation key is an object that carries a key and translation parameters
 */
case class TranslationKey (
    key:    String,
    params: Seq[Any] = Nil
)
{

    /**
     * Adds more translation parameters to the TranslationKey
     *
     * @param p Parameters
     * @return  Extended translation key
     */
    def apply(p: Any*): TranslationKey = this.copy(key, params ++ p)

    /**
     * Retrieves the translated key in the context of the current locale
     */
    def translated(implicit context: ServerLocale = ServerLocale.DefaultLocale): String = context.translate(key, params)

}