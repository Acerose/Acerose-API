package pw.acerose.api.game

/**
 * Refers to the current 'game mode' of a player.
 *
 * This is designed for maximum decoupling and extensibility.
 * It is a value class and is not inheritable.
 *
 * When implementing a novel game mode, the GameMode logic is handled in the form of a
 * behaviour implementation, which receives and consumes data about a player action and their current state.
 * The current state includes the GameMode of the player.
 */
final class GameMode private (private val qualifier: Symbol) extends AnyVal {

    import pw.acerose.language._

    def name: TString = t"acerose.GameMode.${qualifier.toString()}"

}

object GameMode {

    val Survival    = GameMode('survival)
    val Creative    = GameMode('creative)
    val Adventure   = GameMode('adventure)
    val Spectator   = GameMode('spectator)

    def apply(qual: Symbol): GameMode = new GameMode(qual)
    def unapply(gm: GameMode): Tuple1[Symbol] = Tuple1(gm.qualifier)

}
