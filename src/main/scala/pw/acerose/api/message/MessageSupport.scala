package pw.acerose.api.message

/**
 * Common logic template for [[Message]] companion objects
 */
private[message] trait MessageSupport {

    type WrappedForm
    type UnwrappedForm <: Product

    /**
     * Takes the tupled form of the message and converts it to the wrapped object form
     *
     * @param tupledForm    tupled form
     * @return              wrapped form
     */
    def apply(tupledForm: UnwrappedForm): WrappedForm

    /**
     * Takes the wrapped form of the message and converts it to the tupled form
     *
     * @param self          wrapped form
     * @return              tupled form
     */
    def unapply(self: WrappedForm): UnwrappedForm

}
