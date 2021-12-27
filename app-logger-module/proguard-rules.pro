# Logger

# All enums
-keepclassmembers enum com.aok.logger.*.* { *; }
#All Models
-keep class com.aok.logger.model.*.* { *; }

# Suppress logging
-assumenosideeffects class com.support.community.applogger.Log {
    public static *** d(...);
    public static *** w(...);
    public static *** v(...);
    public static *** i(...);
    public static *** e(...);
}