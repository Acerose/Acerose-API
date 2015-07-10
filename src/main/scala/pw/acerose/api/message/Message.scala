package pw.acerose.api.message

/**
 * Base type for Client and Server messages.
 */
sealed trait Message

/**
 * Base type for messages received by the server.
 */
trait ServerMessage extends Message

/**
 * Base type for messages received by the client.
 */
trait ClientMessage extends Message
