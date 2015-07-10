package pw.acerose.api.message

/**
 * KeepAlive message.
 *
 * This is sent from the server to probe a client.
 * It contains a random value with which the client should respond.
 */
final class KeepAlive private ( val challenge:  Int )
    extends AnyRef
            with ServerMessage
            with ClientMessage

object KeepAlive extends MessageSupport {
    type WrappedForm    = KeepAlive
    type UnwrappedForm  = Tuple1[Int]


    /**
     * Takes the wrapped form of the message and converts it to the tupled form
     *
     * @param self          wrapped form
     * @return              tupled form
     */
    override def unapply(self: WrappedForm): UnwrappedForm = Tuple1(self.challenge)

    /**
     * Takes the tupled form of the message and converts it to the wrapped object form
     *
     * @param tupledForm    tupled form
     * @return              wrapped form
     */
    override def apply(tupledForm: UnwrappedForm): WrappedForm = new KeepAlive(tupledForm._1)
}
